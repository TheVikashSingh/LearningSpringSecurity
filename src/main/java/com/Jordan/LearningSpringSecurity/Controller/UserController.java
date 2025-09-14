package com.Jordan.LearningSpringSecurity.Controller;

import com.Jordan.LearningSpringSecurity.Model.Userinfo;
import com.Jordan.LearningSpringSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Userinfo registerUser(@RequestBody Userinfo userinfo){
        return userService.registerUser(userinfo);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Userinfo userinfo){
        return userService.verify(userinfo);
    }

}
