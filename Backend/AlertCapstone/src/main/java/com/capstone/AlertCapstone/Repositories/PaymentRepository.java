package com.capstone.AlertCapstone.Repositories;

import com.capstone.AlertCapstone.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findTopByArtist_ArtistIdAndFlagTrue(Long artistId);
}
