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
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EranosyanServiceImpl implements EranosyanService {

    private final double ZERO_AMOUNT = 0.0;

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

        double creditsSum = getSum(credits, Credit::getAmount);
        double debitsSum = getSum(debits, Debit::getAmount);

        return creditsSum > debitsSum;
    }

    private <T> double getSum(List<T> list, Function<T, Double> getAmount) {
        return list.stream()
                .map(getAmount)
                .reduce(Double::sum)
                .orElse(ZERO_AMOUNT);
    }
}
