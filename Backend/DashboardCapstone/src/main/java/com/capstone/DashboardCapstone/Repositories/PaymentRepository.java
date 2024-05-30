package com.capstone.DashboardCapstone.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.DashboardCapstone.Entites.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
