package ru.evsmanko.mankoff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.entity.UserInfo;
import ru.evsmanko.mankoff.service.UserInfoService;

import java.awt.*;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/userinfo")
public class UserController {
    @Autowired
    private UserInfoService userInfo;
    @GetMapping("/all")
    public ArrayList<UserInfo> getAllUsers(){
        return userInfo.findAll();
    }

}
