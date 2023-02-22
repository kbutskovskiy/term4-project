package ru.evsmanko.mankoff.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentDTO {
    private long id;
    private long userId;
    private int mccCode;
    private double amount;
    private double timeStamp;
}
