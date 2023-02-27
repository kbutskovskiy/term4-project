package ru.evsmanko.mankoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.evsmanko.mankoff.entity.Transfer;
import java.util.List;


@Repository
public interface TransferRepository {
    List<Transfer> findAll();
    List<Transfer> getTransfersBySenderId(long senderId);
    Transfer save(Transfer transfer);
}
