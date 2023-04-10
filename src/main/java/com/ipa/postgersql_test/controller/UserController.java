package com.ipa.postgersql_test.controller;

import com.ipa.postgersql_test.model.UserDTO;
import com.ipa.postgersql_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //    @PostMapping("/user/auth")
//    public String auth(UserDTO userDTO) {
//        userService.auth(userDTO);
//        System.out.println(userDTO);
//        System.out.println(userDTO.getUsername());
//
//        return "main";
//    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(UserDTO userDTO) {
        userService.register(userDTO);
        return "redirect:/";
    }
}
