package ru.evsmanko.mankoff.service;

import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getPaymentsById(long userId);
}
