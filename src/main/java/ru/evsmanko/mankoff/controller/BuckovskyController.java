package ru.evsmanko.mankoff.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import ru.evsmanko.mankoff.service.BuckovskyService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("buckovsky-service")
public class BuckovskyController {
    private final BuckovskyService buckovskyService;
    @GetMapping("/test")
    public void test() {
        log.info("START endpoint buckovsky-service/creditSum");
        buckovskyService.creditSum(2);
        log.info("END endpoint buckovsky-service/creditSum");
    }
}
