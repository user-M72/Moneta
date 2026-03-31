package Moneta.cashflow.service;

import Moneta.cashflow.dto.monthBudget.MonthBudgetReqDto;
import Moneta.cashflow.dto.monthBudget.MonthBudgetResDto;

import java.util.List;
import java.util.UUID;

public interface MonthBudgetService {

    List<MonthBudgetResDto> get();

    MonthBudgetResDto getById(UUID id);

    MonthBudgetResDto create(MonthBudgetReqDto dto);

    MonthBudgetResDto update(UUID id, MonthBudgetReqDto dto);

    void delete(UUID id);
}
