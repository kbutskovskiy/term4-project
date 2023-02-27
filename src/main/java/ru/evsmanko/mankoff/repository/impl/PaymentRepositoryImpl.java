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
        List<Payment> payments =  jdbcTemplate.query("select ID, USER_ID, MCC_CODE, AMOUNT, TIME_STAMP from PAYMENT_NEW",
                this::mapRowToPayment);
        return new ArrayList<Payment>(payments);
    }

    @Override
    public List<Payment> getPaymentsByUserId(long userId) {
        return jdbcTemplate.query(
                "select ID, USER_ID, MCC_CODE, AMOUNT, TIME_STAMP from PAYMENT_NEW where USER_ID=?",
                this::mapRowToPayment, userId);
    }

    @Override
    public Payment save(Payment payment) {
        jdbcTemplate.update(
                "insert into PAYMENT_NEW (USER_ID, MCC_CODE, AMOUNT, TIME_STAMP) values(?, ?, ?, ?)",
                payment.getUserId(),
                payment.getMccCode(),
                payment.getAmount(),
                payment.getTimeStamp());
        return payment;
    }

    private Payment mapRowToPayment(ResultSet row, int rowNum)
            throws SQLException{
        return new Payment(row.getLong("id"), row.getLong("user_Id"), row.getInt("mcc_Code"),
                row.getDouble("amount"), row.getDouble("time_Stamp"));
    }
}