package ru.evsmanko.mankoff.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.service.MikhaylovService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MikhaylovServiceImpl implements MikhaylovService {
    private final DebitRepository debitRepository;
    public String debitRemains() {
        double allUserDebitRemains=0;
        List<Debit> debitAll= (List<Debit>) debitRepository.findAll();
        for (Debit debit : debitAll){
            allUserDebitRemains+=debit.getAmount();
        }
        return String.valueOf(allUserDebitRemains);
    }
}
