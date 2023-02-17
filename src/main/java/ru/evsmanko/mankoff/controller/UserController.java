package ru.evsmanko.mankoff.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.evsmanko.mankoff.entity.UserInfo;
import ru.evsmanko.mankoff.service.UserInfoService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserInfoService userInfoService;
    @GetMapping("/{id}")
    public String getUserInfoById(@PathVariable long id, Model model){
        List<UserInfo> userInfo = userInfoService.findUserInfoById(id);
        model.addAttribute("userInfo",userInfo);
        return "info";
    }

    @ResponseBody
    @GetMapping("/all")
    public ArrayList<UserInfo> getAllUsers(Model model){
        ArrayList<UserInfo> usersInfo = userInfoService.findAll();
        model.addAttribute("userInfo");
        return usersInfo;
    }
    @PostMapping("/save")
    public String saveUserInfo(@RequestBody UserInfo userInfo,Model model){
        userInfoService.save(userInfo);
        model.addAttribute("userInfo",userInfoService.findUserInfoById(userInfo.getId()));
        return "info";
    }
}
