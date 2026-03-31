package Moneta.cashflow.repository;

import Moneta.cashflow.entity.MonthBudget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MonthBudgetRepository extends JpaRepository<MonthBudget, UUID> {
}
