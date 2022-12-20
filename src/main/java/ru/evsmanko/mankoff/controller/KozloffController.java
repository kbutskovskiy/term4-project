package ru.evsmanko.mankoff.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.service.KozloffService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("kozloff-service")
public class KozloffController {

    private final KozloffService kozloffService;

    @GetMapping("/test")
    public void test() {
        log.info("START endpoint kozloff-service/test");
        kozloffService.test();
        log.info("END endpoint kozloff-service/test");
    }
}
