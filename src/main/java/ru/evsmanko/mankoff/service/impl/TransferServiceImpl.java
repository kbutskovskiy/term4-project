package ru.evsmanko.mankoff.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evsmanko.mankoff.entity.Transfer;
import ru.evsmanko.mankoff.repository.TransferRepository;
import ru.evsmanko.mankoff.service.TransferService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final TransferRepository transferRepository;
    @Override
    public List<Transfer> getTransfersBySenderId(long id) {
        return transferRepository.getTransfersBySenderId(id);
    }

    @Override
    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }
}
