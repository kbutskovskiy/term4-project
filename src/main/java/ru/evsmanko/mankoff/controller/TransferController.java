package ru.evsmanko.mankoff.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.evsmanko.mankoff.entity.Transfer;
import ru.evsmanko.mankoff.service.TransferService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor

public class TransferController {
    private final TransferService transferService;
    @GetMapping("/transfers/{id}")
    public String transfersList(@PathVariable long id, Model model){
        List<Transfer> transfersList = transferService.getTransfersBySenderId(id);
        model.addAttribute("transfersList", transfersList);
        return "transfers";
    }
    @GetMapping("/new-transfer")
    public String newTransfer(Model model){
        model.addAttribute("newTransfer",new Transfer());
        return "new-transfer";
    }
    @PostMapping("/new-transfer")
    public String saveTransfer(@ModelAttribute("newTransfer") Transfer transfer){
        transferService.save(transfer);
        return "new-transfer";
    }
}
