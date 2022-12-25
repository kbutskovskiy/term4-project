package ru.evsmanko.mankoff.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.service.UstinoffService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("ustinoff-service")
public class UstinoffController {
    private final UstinoffService ustinoffService;

    @GetMapping("/userInfoToJson/{id}")
    public void userInfoToJson(@PathVariable int id) {
        log.info("START endpoint usinoffService/exportToJson, id:{}", id);
        String userInfo = ustinoffService.exportToJson(id);
        log.info("END endpoint usinoffService/exportToJson, user info:\n{}",userInfo);
    }
}
