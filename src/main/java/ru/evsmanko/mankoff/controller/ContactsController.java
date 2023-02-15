package ru.evsmanko.mankoff.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ContactsController {
    @GetMapping("/contacts")
    public String getContacts(Model model) {
        model.addAttribute("fullAddress","Russia, Moscow, Andropov avenue, 18, building 1")
                .addAttribute("telephonePrivate1","8 800 250-0-520")
                .addAttribute("telephonePrivate2", " +7 495 777-000-1")
                .addAttribute("telephoneBusiness1", "8 800 250-0-199");
        return "contacts";
    }
}
