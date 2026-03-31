package Moneta.cashflow.repository;

import Moneta.cashflow.entity.MonthBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MonthBudgetRepository extends JpaRepository<MonthBudget, UUID> {
}
