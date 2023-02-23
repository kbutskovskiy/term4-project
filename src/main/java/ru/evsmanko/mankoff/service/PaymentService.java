package ru.evsmanko.mankoff.service;

import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.dto.PaymentDTO;
import ru.evsmanko.mankoff.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getPaymentsById(long userId);
    PaymentDTO save(PaymentDTO paymentDTO);
}
