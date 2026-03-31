package Moneta.cashflow.service.impl;

import Moneta.cashflow.dto.monthBudget.MonthBudgetReqDto;
import Moneta.cashflow.dto.monthBudget.MonthBudgetResDto;
import Moneta.cashflow.mapper.MonthBudgetMapper;
import Moneta.cashflow.repository.MonthBudgetRepository;
import Moneta.cashflow.service.MonthBudgetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MonthBudgetServiceImpl implements MonthBudgetService {

    private  final MonthBudgetRepository repository;
    private final MonthBudgetMapper mapper;

    @Override
    public List<MonthBudgetResDto> get() {
        return List.of();
    }

    @Override
    public MonthBudgetResDto getById(UUID id) {
        return null;
    }

    @Override
    public MonthBudgetResDto create(MonthBudgetReqDto dto) {
        return null;
    }

    @Override
    public MonthBudgetResDto update(UUID id, MonthBudgetReqDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
