package org.ksusha.controllers;

import javassist.NotFoundException;
import org.ksusha.dao.RoleRepository;
import org.ksusha.entities.User;
import org.ksusha.entities.User_Role;
import org.ksusha.servises.RoleService;
import org.ksusha.servises.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "/register")
public class RegisterController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final RoleService roleService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public RegisterController(UserService userService, RoleService roleService,
                              BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }


    @PostMapping(path = "/sendData/")
    @ResponseBody
    public String registerUser(@RequestBody User user) throws NotFoundException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); // encrypted user's password and save it to the database
        User_Role user_role = new User_Role(); //
        Set<User_Role> defRoles = new HashSet<>(); // created set with default role
        user_role.setRole(roleService.findById((long) 2));
        user_role.setUser(user);
        defRoles.add(user_role);
        user.setUserRoles(defRoles);
        userService.registerUser(user);
        return "OK";  // I can't do any post throw console
    }


    //todo fix problem with register user csrf token
    //todo fix problem with logout

}
