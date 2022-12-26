package ru.evsmanko.mankoff.service.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.BuckovskyService;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.User;
import java.lang.String;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BuckovskyServiceImpl implements BuckovskyService{
    private final CreditRepository creditRepository;
    private final UserRepository userRepository;
    @Value("${app.currency}")
    private String currency;
    @Value("${app.USD}")
    private double coefficientUSD;
    @Value("${app.RUB}")
    private double coefficientRUB;
    @Value("${app.EUR}")
    private double coefficientEUR;
    public String creditSum(long id){
        User user = userRepository.getUserById(id);
        if (user == null){
            return "User doesn't exist";
        }
        double sumCredit = 0;
        List<Credit> creditList = creditRepository.findAllByUserId(id);
        for (Credit credit : creditList) {
            sumCredit += credit.getAmount();
        }
        switch (currency) {
            case ("EUR") -> sumCredit *= coefficientEUR / coefficientRUB;
            case ("USD") -> sumCredit *= coefficientUSD / coefficientRUB;
        }
        return (String.valueOf(sumCredit) + " " + currency);
    }
}
