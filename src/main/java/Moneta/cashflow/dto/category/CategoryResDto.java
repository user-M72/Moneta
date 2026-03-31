package Moneta.cashflow.dto.category;

import Moneta.cashflow.entity.EnumStatus.TransactionType;

import java.util.UUID;

public record CategoryResDto(

        UUID id,
        String name,
        String icon,
        String color,
        TransactionType type,
        boolean deleted

) {
}
