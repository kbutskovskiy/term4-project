package ru.evsmanko.mankoff.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.service.BuckovskyService;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BuckovskyServiceImpl implements BuckovskyService{
    CreditRepository creditRepository;
    DebitRepository debitRepository;
    private double sumCredit = 0;
    private double sumDebit = 0;

    public double creditSum(long id){
        List<Credit> creditList = creditRepository.findAllByUserId(id);
        for (Credit credit : creditList) {
            sumCredit += credit.getAmount();
        }
        List<Debit> debitList = debitRepository.findAllByUserId(id);
        for (Debit debit : debitList){
            sumDebit += debit.getAmount();
        }
        if (sumCredit > sumDebit){
            return sumCredit - sumDebit;
        }
        else{
            return 0;
        }
    }
}
