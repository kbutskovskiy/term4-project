package ru.evsmanko.mankoff.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/credit/{id}")
    public String task2(@PathVariable long id) {
        log.info("START endpoint buckovsky-service/creditSum, id: {}", id);
        String response = buckovskyService.creditSum(id);
        log.info("END endpoint buckovsky-service/creditSum, response: {}", response);
        return response;
    }

}
