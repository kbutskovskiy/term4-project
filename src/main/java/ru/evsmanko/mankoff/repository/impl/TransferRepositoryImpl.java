package ru.evsmanko.mankoff.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.evsmanko.mankoff.entity.Transfer;
import ru.evsmanko.mankoff.repository.TransferRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TransferRepositoryImpl implements TransferRepository {
    private final JdbcTemplate jdbcTemplate;
    private Transfer mapRow(ResultSet row, int rowNum)
            throws SQLException {
        return new Transfer(row.getLong("ID"), row.getLong("SENDER_ID"), row.getLong("RECIEVER_ID"),
                row.getDouble("AMOUNT"), row.getDouble("TIME_STAMP"));
    }
    @Override
    public List<Transfer> findAll(){
        return jdbcTemplate.query("SELECT * FROM TRANSFER", this::mapRow);
    }
    @Override
    public List<Transfer> getTransfersBySenderId(long senderId){
        return jdbcTemplate.query("SELECT * FROM TRANSFER WHERE SENDER_ID=?", new Long[]{senderId}, this::mapRow);
    }
    @Override
    public Transfer save(Transfer transfer){
        List<Transfer> tempList= findAll();
        long maxId = 0;
        for (int i=0; i<tempList.size();i++){
            if (tempList.get(i).getId()>maxId){
                maxId=tempList.get(i).getId();
            }
        }
        jdbcTemplate.update("INSERT INTO TRANSFER (ID, SENDER_ID, RECIEVER_ID, AMOUNT, TIME_STAMP) VALUES(?,?,?,?,?)", ++maxId, transfer.getSenderId(), transfer.getRecieverId(),transfer.getAmount(), transfer.getTimeStamp());
        transfer.setId(maxId);
        return transfer;
    }
}
