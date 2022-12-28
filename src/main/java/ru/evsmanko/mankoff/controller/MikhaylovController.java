package ru.evsmanko.mankoff.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import ru.evsmanko.mankoff.service.MikhaylovService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("Mikhaylov")
public class MikhaylovController {
    private final MikhaylovService MikhaylovService;

    @GetMapping("/debitRemains")
    public String task3() {
        log.info("START endpoint dz9");
        String response = MikhaylovService.debitRemains();
        log.info("END endpoint dz9, response: {}", response);
        return response;
    }
}
