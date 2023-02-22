package ru.evsmanko.mankoff.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRANSFER")
public class Transfer {
    @Id
    private long id;
    @Column(name="SENDER_ID")
    private long senderId;
    @Column(name="RECIEVER_ID")
    private long recieverId;
    @Column(name="AMOUNT")
    private double amount;
    @Column(name="TIME_STAMP")
    private double timeStamp=1;
}
