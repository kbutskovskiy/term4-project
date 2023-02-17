package ru.evsmanko.mankoff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.Payment;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PaymentRepository {
    ArrayList<Payment> findAll();

    List<Payment> getPaymentsByUserId(long userId);
    Payment save(Payment payment);
}
