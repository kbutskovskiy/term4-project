package ru.evsmanko.mankoff.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Slf4j
@Controller
public class BankInfoController{

    @GetMapping("/info")
    public String showUserInfo(Model model) {
        String header = "Информация о банке";
        String about = "МТС Банк (ПАО «МТС-Банк») – универсальный коммерческий банк, основанный в 1993 году. Действует на основании Генеральной лицензии №2268, выданной Банком России 17.12.2014 г. Входит в число 50 ведущих банков России по величине активов. Основными акционерами являются Частная компания с ограниченной ответственностью Мобайл ТелеСистемс Б.В. – дочерняя компания ПАО «Мобильные ТелеСистемы».";
        model.addAttribute("header",header);
        model.addAttribute("about",about);
        return "info";
    }
}