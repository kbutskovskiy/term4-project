package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PAYMENT_NEW")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "MCC_CODE")
    private int mccCode;
    @Column(name = "AMOUNT")
    private double amount;
    @Column(name = "TIME_STAMP")
    private double timeStamp;
}
