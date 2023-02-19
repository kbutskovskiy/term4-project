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
    private long id;
    @Column(name = "USERID")
    private long userId;
    @Column(name = "MCCCODE")
    private int mccCode;
    @Column(name = "AMOUNT")
    private double amount;
    @Column(name = "TIMESTAMP")
    private double timeStamp;
}
