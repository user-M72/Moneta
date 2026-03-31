package Moneta.cashflow.entity;

import Moneta.cashflow.entity.EnumStatus.TransactionType;
import Moneta.cashflow.entity.baseDomain.BaseDomain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
        name = "transactions",
        indexes = {
                @Index(columnList = "month_budget_id"),
                @Index(columnList = "category_id"),
                @Index(columnList = "date")
        }
)
@Getter
@Setter
public class Transaction extends BaseDomain {

    @NotNull
    @Positive
    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @NotBlank
    private String note;

    @NotNull
    @PastOrPresent
    @Column(nullable = false)
    private LocalDate date;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    private boolean deleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_budget_id", nullable = false)
    private MonthBudget monthBudget;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
