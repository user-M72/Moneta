package Moneta.cashflow.service;

import Moneta.cashflow.dto.transaction.TransactionReqDto;
import Moneta.cashflow.dto.transaction.TransactionResDto;

import java.util.List;
import java.util.UUID;

public interface TransactionService {

    List<TransactionResDto> get();

    TransactionResDto getById(UUID id);

    TransactionResDto create(TransactionReqDto dto);

    TransactionResDto update(UUID id);

    void delete(UUID id);

}
