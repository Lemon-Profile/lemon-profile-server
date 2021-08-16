package com.lemon.lemonprofile.controller;

import com.lemon.lemonprofile.model.TbUserVo;
import com.lemon.lemonprofile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<TbUserVo> getUsers() {
        return userService.getUsers();
    }

}
