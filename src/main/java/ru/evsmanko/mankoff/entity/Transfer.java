package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Table(name = "tranfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transferId;
    private long senderId;
    private long recieverId;
    private double amount;
    private double timeStamp=1;
}
