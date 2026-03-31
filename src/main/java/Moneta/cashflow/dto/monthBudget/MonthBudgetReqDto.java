package Moneta.cashflow.dto.monthBudget;

import java.math.BigDecimal;
import java.util.UUID;

public record MonthBudgetReqDto(

        int year,
        int month,
        BigDecimal totalAmount,
        boolean delete,
        UUID userId,
        UUID transactionId
) {
}
