package Moneta.cashflow.dto.category;

import Moneta.cashflow.entity.EnumStatus.TransactionType;

public record CategoryReqDto(

        String name,
        String icon,
        String color,
        TransactionType type,
        boolean deleted
) {
}
