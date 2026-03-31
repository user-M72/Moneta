package Moneta.cashflow.service.impl;

import Moneta.cashflow.dto.transaction.TransactionReqDto;
import Moneta.cashflow.dto.transaction.TransactionResDto;
import Moneta.cashflow.mapper.TransactionMapper;
import Moneta.cashflow.repository.TransactionRepository;
import Moneta.cashflow.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    @Override
    public List<TransactionResDto> get() {
        return List.of();
    }

    @Override
    public TransactionResDto getById(UUID id) {
        return null;
    }

    @Override
    public TransactionResDto create(TransactionReqDto dto) {
        return null;
    }

    @Override
    public TransactionResDto update(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
