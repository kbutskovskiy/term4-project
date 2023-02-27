package ru.evsmanko.mankoff.repository.impl;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.evsmanko.mankoff.dto.PaymentDTO;
import ru.evsmanko.mankoff.entity.Payment;
import ru.evsmanko.mankoff.mapper.PaymentMapper;
import ru.evsmanko.mankoff.repository.PaymentRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PaymentRepositoryImpl implements PaymentRepository {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public ArrayList<Payment> findAll() {
        List<Payment> payments =  jdbcTemplate.query("select id, userId, mccCode, amount, timeStamp from Payment",
                this::mapRowToPayment);
        return new ArrayList<Payment>(payments);
    }

    @Override
    public List<Payment> getPaymentsByUserId(long userId) {
        return jdbcTemplate.query(
                "select id, userId, mccCode, amount, timeStamp from Payment where userId=?",
                this::mapRowToPayment, userId);
    }

    @Override
    public Payment save(Payment payment) {
        jdbcTemplate.update(
                "insert into Payment (id, userId, mccCode, amount, timeStamp) values(?, ?, ?, ?, ?)",
                payment.getId(),
                payment.getUserId(),
                payment.getMccCode(),
                payment.getAmount(),
                payment.getTimeStamp());
        return payment;
    }

    private Payment mapRowToPayment(ResultSet row, int rowNum)
            throws SQLException{
        return new Payment(row.getLong("id"), row.getLong("userId"), row.getInt("mccCode"),
                row.getDouble("amount"), row.getDouble("timeStamp"));
    }
}