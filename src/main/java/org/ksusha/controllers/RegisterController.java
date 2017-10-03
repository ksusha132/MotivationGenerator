package org.ksusha.controllers;

import javassist.NotFoundException;
import org.ksusha.entities.User;
import org.ksusha.servises.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(path = "/register")
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping(path = "/sendData/")
    @ResponseBody
    public String registerUser(@RequestBody User user) throws NotFoundException {
        userService.registerUser(user);
        return "OK";  // I can't do any post throw console
    }


    /*@RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            customLogoutSuccessHandler.onLogoutSuccess(request, response, auth);
        }
        return "OK";
    }*/
    //todo fix problem with register user csrf token
    //todo fix problem with logout

}
