package com.example.withdrawal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlySettlementsRepo extends JpaRepository<MonthlySettlement, Integer> {
    List<MonthlySettlement> findByUserIdAndDateBetween(int userId, LocalDate startDate, LocalDate endDate);
}