package ru.evsmanko.mankoff.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Slf4j
@Controller
public class BankInfoController{

    @GetMapping("/info")
    public String showUserInfo() {
        return "info";
    }
}