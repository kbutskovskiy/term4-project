package ru.evsmanko.mankoff.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import ru.evsmanko.mankoff.entity.Payment;
import ru.evsmanko.mankoff.repository.PaymentRepository;
import ru.evsmanko.mankoff.service.PaymentService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserInfoController {
    private final PaymentService paymentService;
    @GetMapping("/user")
    public String showUserInfo(Model model) {
        model.addAttribute("nameAndSurname", "Кирилл Буцковский");
        model.addAttribute("cardBalance", "1240");
        model.addAttribute("depositBalance", "56300");
        model.addAttribute("creditSum", "5600");
        model.addAttribute("phoneBalance", "2");
        return "UserInfo";
    }

    @GetMapping("/payment/{id}")
    public String showUserPaymentById(@PathVariable long id, Model model){
        List<Payment> paymentList = paymentService.getPaymentsById(id);
        model.addAttribute("payments", paymentList);
        return "UserPayment";
    }

    @PostMapping("/save")
    public void savePayment(@RequestBody Payment payment){
        log.info("START save endpoint");
        log.info("END save endpoint");
        System.out.print(paymentService.save(payment).getId());
    }
}