package hello.controllers;

import hello.servises.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import hello.entities.User;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/find/all")
    @ResponseBody
    public List<User> getAllUsers() throws NotFoundException {
        return userService.getAll();
    }

    @GetMapping(path = "/find/id/{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id) throws NotFoundException {
        return userService.getById(id);
    }

    @GetMapping(path = "/find/age/{age}")
    @ResponseBody
    public List<User> getUserByAge(@PathVariable Integer age) throws NotFoundException {
        return userService.findByAge(age);

    }

    @GetMapping(path = "/find/secName/{secName}")
    @ResponseBody
    public List<User> getUserBySecName(@PathVariable String secName) throws NotFoundException {
        return userService.findBySecName(secName);

    }

    @GetMapping(path = "/find/name/{name}")
    @ResponseBody
    public List<User> getUser(@PathVariable String name) throws NotFoundException {
        return userService.findByName(name);

    }

//    @GetMapping(path = "/update/")
//    @ResponseBody
//    public User updateUser() throws NotFoundException {
//       User user = userService.updateUser();
    // how can I transmit User but not each parameter in request?
//    }

    @GetMapping(path = "/delete/id/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable Long id) throws NotFoundException {
        userService.deleteUser(id);
    }

}
