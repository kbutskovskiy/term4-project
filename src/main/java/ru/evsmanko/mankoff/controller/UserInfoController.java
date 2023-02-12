package ru.evsmanko.mankoff.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Slf4j
@Controller
public class UserInfoController {
    @GetMapping("/user")
    public String showUserInfo(Model model) {
        model.addAttribute("nameAndSurname", "Кирилл Буцковский");
        model.addAttribute("cardBalance", "1240");
        model.addAttribute("depositBalance", "56300");
        model.addAttribute("creditSum", "5600");
        model.addAttribute("phoneBalance", "2");
        return "UserInfo";
    }
}