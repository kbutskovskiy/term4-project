package ru.evsmanko.mankoff.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evsmanko.mankoff.service.EranosyanService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eranosyan")
public class EranosyanController {

    private final EranosyanService eranosyanService;

    @GetMapping
    public ResponseEntity<?> getUsersWithCreditMoreThanDebit() {
        return ResponseEntity.ok().body(eranosyanService.getUsersWithCreditMoreThanDebit());
    }
}
