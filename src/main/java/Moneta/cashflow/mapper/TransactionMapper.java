package Moneta.cashflow.mapper;

import Moneta.cashflow.dto.transaction.TransactionReqDto;
import Moneta.cashflow.dto.transaction.TransactionResDto;
import Moneta.cashflow.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {

    TransactionResDto toDto(Transaction transaction);

    Transaction toEntity(TransactionReqDto dto);
}
