package com.capstone.AlertCapstone.Repositories;

import com.capstone.AlertCapstone.Entities.RoyaltyContract;
import com.capstone.AlertCapstone.Entities.Enums.Approach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoyaltyContractRepository extends JpaRepository<RoyaltyContract, Long> {
    RoyaltyContract findTopByArtist_ArtistIdAndFlagTrueAndApproached(Long artistId, Approach approached);
    RoyaltyContract findTopByManager_ManagerIdAndFlagTrueAndApproached(Long managerId, Approach approached);
}
