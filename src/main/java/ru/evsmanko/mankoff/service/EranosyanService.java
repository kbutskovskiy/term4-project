package ru.evsmanko.mankoff.service;

import ru.evsmanko.mankoff.entity.User;

import java.util.List;

public interface EranosyanService {

    List<User> getUsersWithCreditMoreThanDebit();

}
