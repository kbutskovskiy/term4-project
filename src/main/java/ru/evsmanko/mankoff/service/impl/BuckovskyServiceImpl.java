package ru.evsmanko.mankoff.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.BuckovskyService;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.User;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BuckovskyServiceImpl implements BuckovskyService{
    private final CreditRepository creditRepository;
    private final UserRepository userRepository;
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
        return String.valueOf(sumCredit);
    }
}
