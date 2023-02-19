package ru.evsmanko.mankoff.service;


import ru.evsmanko.mankoff.entity.Transfer;

import java.util.List;

public interface TransferService {
    List<Transfer> getTransfersBySenderId(long id);
    Transfer save(Transfer transfer);
}
