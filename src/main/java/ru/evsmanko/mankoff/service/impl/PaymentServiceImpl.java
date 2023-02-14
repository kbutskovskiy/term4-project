package ru.evsmanko.mankoff.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Payment;
import ru.evsmanko.mankoff.service.PaymentService;
import ru.evsmanko.mankoff.repository.PaymentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    @Override
    public List<Payment> getPaymentsById(long userId) {
        return paymentRepository.getPaymentsByUserId(userId);
    }

    @Override
    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }
}
