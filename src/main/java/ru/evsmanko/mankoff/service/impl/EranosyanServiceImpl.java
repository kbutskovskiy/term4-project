package ru.evsmanko.mankoff.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Credit;
import ru.evsmanko.mankoff.entity.Debit;
import ru.evsmanko.mankoff.entity.User;
import ru.evsmanko.mankoff.repository.CreditRepository;
import ru.evsmanko.mankoff.repository.DebitRepository;
import ru.evsmanko.mankoff.repository.UserRepository;
import ru.evsmanko.mankoff.service.EranosyanService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EranosyanServiceImpl implements EranosyanService {

    private final UserRepository userRepository;
    private final CreditRepository creditRepository;
    private final DebitRepository debitRepository;

    public List<User> getUsersWithCreditMoreThanDebit() {
        List<User> users = Optional.ofNullable(userRepository.findAll()).orElseThrow(NullPointerException::new);

        return users.stream().filter(this::isUserCreditMoreThanDebit).collect(Collectors.toList());
    }

    private boolean isUserCreditMoreThanDebit(User user) {
        List<Credit> credits = creditRepository.findAllByUserId(user.getId());
        List<Debit> debits = debitRepository.findAllByUserId(user.getId());

        double creditsSum = credits.stream().map(Credit::getAmount).reduce(Double::sum).orElse(-1.0);
        double debitsSum = debits.stream().map(Debit::getAmount).reduce(Double::sum).orElse(-1.0);

        return creditsSum > debitsSum;
    }
}
