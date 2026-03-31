package Moneta.cashflow.dto.transaction;

import Moneta.cashflow.entity.EnumStatus.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record TransactionResDto(

        UUID id,
        BigDecimal amount,
        String note,
        LocalDate date,
        TransactionType type,
        boolean delete,
        UUID monthBudgetId,
        UUID categoryId
) {
}
