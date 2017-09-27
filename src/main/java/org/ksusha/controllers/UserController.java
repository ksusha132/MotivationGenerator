package org.ksusha.controllers;

import org.json.simple.JSONObject;
import org.ksusha.entities.User;
import org.ksusha.entities.User_Info;
import org.ksusha.servises.UserService;
import org.ksusha.servises.User_InfoService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final User_InfoService user_infoService;

    private final UserService userService;

    @Autowired
    public UserController(User_InfoService user_infoService, UserService userService) {
        this.user_infoService = user_infoService;
        this.userService = userService;
    }


    @GetMapping(path = "/find/all")
    @ResponseBody
    public List<User_Info> getAllUsers() throws NotFoundException {
        return user_infoService.getAll();
    }

    @GetMapping(path = "/find/id/{id}")
    @ResponseBody
    public JSONObject getUser(@PathVariable Long id) throws NotFoundException {
        User user = userService.getUserById(id);
        return fillUserIntoIntoJSON(user);
    }

    @GetMapping(path = "/find/login/{login}", produces = "application/json")
    @ResponseBody
    public JSONObject getUserByLogin(@PathVariable String login) throws NotFoundException {
        User user = userService.getUserByLogin(login);
        if (user == null) {
            user = userService.getUserByLoginLike(login);
        }
        return fillUserIntoIntoJSON(user);
    }

    @GetMapping(path = "/find/age/{age}")
    @ResponseBody
    public List<User_Info> getUserByAge(@PathVariable Integer age) throws NotFoundException {
        return user_infoService.findByAge(age);

    }

    @GetMapping(path = "/find/ageWithParameters/{age1}/{age2}")
    @ResponseBody
    public List<User_Info> getUserByAgeWithParameters(@PathVariable Integer age1, @PathVariable Integer age2) throws NotFoundException {
        return user_infoService.findByAgeWithParameters(age1, age2);

    }

    @GetMapping(path = "/find/secName/{secName}")
    @ResponseBody
    public List<User_Info> getUserBySecName(@PathVariable String secName) throws NotFoundException {
        List<User_Info> list = user_infoService.findBySecName(secName);
        if ((list != null) && !list.isEmpty()) {
            return list;
        } else {
            return user_infoService.findBySecNameLike(secName);
        }
    }

    @GetMapping(path = "/find/name/{name}")
    @ResponseBody
    public List<User_Info> getUser(@PathVariable String name) throws NotFoundException {
        List<User_Info> list = user_infoService.findByName(name);
        if ((list != null) && !list.isEmpty()) {
            return list;
        } else {
            return user_infoService.findByNameLike(name);
        }

    }

    @PostMapping(path = "/update/")
    @ResponseBody
    public String updateUser(@RequestBody User_Info user) throws NotFoundException {
        user_infoService.updateUser(user);
        return "OK";
    }

    @PostMapping(path = "/create/")
    @ResponseBody
    public String createUser(@RequestBody User_Info user) throws NotFoundException {
        user_infoService.createUser(user);
        return "OK";
    }

    @GetMapping(path = "/delete/id/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable Long id) throws NotFoundException {
        user_infoService.deleteUser(id);
    }


    public static JSONObject fillUserIntoIntoJSON(User user) {
        JSONObject retVal = new JSONObject();
        retVal.put("name", user.getUser_info().getName());
        retVal.put("age", user.getUser_info().getAge());
        retVal.put("secName", user.getUser_info().getSecName());
        retVal.put("login", user.getLogin());
        retVal.put("password", user.getPassword());
        retVal.put("roles", user.getRoles());
        return retVal;
    }
}
