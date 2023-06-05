package com.example.demoInertia.controller;

import com.example.demoInertia.algorithm.RandomString;
import com.example.demoInertia.service.GMailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demoInertia.dto.APIResponse;
import com.example.demoInertia.dto.Login;
import com.example.demoInertia.model.User;
import com.example.demoInertia.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/registration")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "Registration Completed Successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody Login login){
        userService.login(login);
        return "Logged In Successfully!";
    }

    @GetMapping("/checkEmail")
    public APIResponse usedEmail(@RequestHeader String email){
        return userService.usedEmail(email);
    }

    @PostMapping("api/sendGmail/{sendTo}")
    private void sendGmail(@PathVariable String sendTo) throws Exception {
        GMailer gMailer = new GMailer();
        String randomString= RandomString.getAlphaNumericString(12);
        String message = "Confirmation Code : " +randomString;
        gMailer.sendMail("subject",message,sendTo);
    }
}
