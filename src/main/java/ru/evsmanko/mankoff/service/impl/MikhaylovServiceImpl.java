package ru.evsmanko.mankoff.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.service.MikhaylovService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MikhaylovServiceImpl implements MikhaylovService {
    private final DebitRepository debitRepository;
    @Value("${dz9.currency}")
    private String currency;
    @Value("${dz9.RUB}")
    private double ratioRUB;
    @Value("${dz9.EUR}")
    private double ratioEUR;
    public String debitRemains() {
        double allUserDebitRemains=0;
        List<Debit> debitAll= (List<Debit>) debitRepository.findAll();
        for (Debit debit : debitAll){
            allUserDebitRemains+=debit.getAmount();
        }
        allUserDebitRemains = allUserDebitRemains/ratioRUB;
        switch (currency){
            case("RUB"): allUserDebitRemains *= ratioRUB;
                break;
            case("EUR"): allUserDebitRemains *= ratioEUR;
        }
        return (allUserDebitRemains + " " + currency);
    }
}
