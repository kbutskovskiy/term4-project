package ru.evsmanko.mankoff.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.evsmanko.mankoff.dto.PaymentDTO;
import ru.evsmanko.mankoff.entity.Payment;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
    PaymentDTO mapEntityToDTO(Payment payment);
    Payment mapDTOtoEntity(PaymentDTO paymentDTO);
}