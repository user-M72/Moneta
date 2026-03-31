package Moneta.cashflow.dto.sumStatus;

import java.time.Instant;

public record StatusEx(

        String description,
        Instant sum,
        SumStatus statusMoney
) {
}
