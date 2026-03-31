package Moneta.cashflow.mapper;

import Moneta.cashflow.dto.monthBudget.MonthBudgetReqDto;
import Moneta.cashflow.dto.monthBudget.MonthBudgetResDto;
import Moneta.cashflow.entity.MonthBudget;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MonthBudgetMapper {

    MonthBudgetResDto toDto(MonthBudget monthBudget);

    MonthBudget toEntity(MonthBudgetReqDto dto);
}
