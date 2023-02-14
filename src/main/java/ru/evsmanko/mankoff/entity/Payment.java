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
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private long paymentId;
    private int MCCCode;
    private double amount;
    private double timeStamp;
}
