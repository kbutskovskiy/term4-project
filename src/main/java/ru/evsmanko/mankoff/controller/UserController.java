package ru.evsmanko.mankoff.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.evsmanko.mankoff.entity.UserInfo;
import ru.evsmanko.mankoff.service.UserInfoService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/userinfo")
@RequiredArgsConstructor
public class UserController {
    private final UserInfoService userInfoService;
    @GetMapping("/{id}")
    public Optional<UserInfo> getUserInfoById(@PathVariable long id){
        Optional<UserInfo> userInfo = userInfoService.findUserInfoById(id);
        return userInfo;
    }

    @GetMapping("/all")
    public ArrayList<UserInfo> getAllUsers(){
        return userInfoService.findAll();
    }
    @PostMapping("/save")
    public void saveUserInfo(UserInfo userInfo){
        userInfoService.save(userInfo);
    }
}
