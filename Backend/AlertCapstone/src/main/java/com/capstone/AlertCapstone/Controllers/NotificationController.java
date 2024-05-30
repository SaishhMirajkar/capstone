package com.capstone.AlertCapstone.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.AlertCapstone.Entities.Artists;
import com.capstone.AlertCapstone.Entities.Managers;
import com.capstone.AlertCapstone.Entities.Payment;
import com.capstone.AlertCapstone.Entities.RoyaltyContract;
import com.capstone.AlertCapstone.Entities.Streams;
import com.capstone.AlertCapstone.Entities.Enums.Approach;
import com.capstone.AlertCapstone.Modules.NotificationResponse;
import com.capstone.AlertCapstone.Repositories.ArtistsRepository;
import com.capstone.AlertCapstone.Repositories.ManagersRepository;
import com.capstone.AlertCapstone.Repositories.PaymentRepository;
import com.capstone.AlertCapstone.Repositories.RoyaltyContractRepository;
import com.capstone.AlertCapstone.Repositories.StreamsRepository;

@CrossOrigin(value="http://localhost:3000/")
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private ArtistsRepository artistsRepository;

    @Autowired
    private ManagersRepository managersRepository;

    @Autowired
    private StreamsRepository streamsRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RoyaltyContractRepository royaltyContractRepository;

    @GetMapping("/artist/{id}")
    public NotificationResponse getArtistNotifications(@PathVariable Long id) {
        NotificationResponse response = new NotificationResponse();

        // Check Streams table
        Streams topStream = streamsRepository.findTopByOrderByStreamsDesc();
        if (topStream != null && topStream.getFlag() && topStream.getSong().getArtist().getArtistId().equals(id)) {
            response.setStreams("Congrats your song '" + topStream.getSong().getTitle() + "' is the most viewed.");
        }

        List<Payment> payments = paymentRepository.findByArtist_ArtistIdAndFlagTrue(id);
        if (payments != null && !payments.isEmpty()) {
            List<String> payoutMessages = new ArrayList<>();
            for (Payment payment : payments) {
                payoutMessages.add("Your Royalty payments credited: " + payment.getPaymentAmount());
            }
            response.setPayout(payoutMessages);
        }

        // Check RoyaltyContract table
        RoyaltyContract royaltyContract = royaltyContractRepository.findTopByArtist_ArtistIdAndFlagTrueAndApproached(id, Approach.ARTISTS);
        if (royaltyContract != null) {
            Managers manager = royaltyContract.getManager();
            if (manager != null) {
                response.setRequest(manager.getCompany() + " has offered a partnership.");
            }
        }

        return response;
    }
    @PatchMapping("/artist/{id}/update-flags-streams")
    public ResponseEntity<Void> updateArtistFlagsStreams(@PathVariable Long id) {
        // Update flags for Streams, Payment, and RoyaltyContract related to the artist
        streamsRepository.updateFlagByArtistId(id);
        return ResponseEntity.noContent().build(); // Respond with 204 No Content
    }
    @PatchMapping("/artist/{id}/update-flags-payment")
    public ResponseEntity<Void> updateArtistFlagsPayment(@PathVariable Long id) {
        // Update flags for Streams, Payment, and RoyaltyContract related to the artist
        paymentRepository.updateFlagByArtistId(id);
        return ResponseEntity.noContent().build(); // Respond with 204 No Content
    }
    @PatchMapping("/artist/{id}/update-flags-royalty")
    public ResponseEntity<Void> updateArtistFlagsRoyalty(@PathVariable Long id) {
        // Update flags for Streams, Payment, and RoyaltyContract related to the artist
        royaltyContractRepository.updateFlagByArtistIdOrManagerId(id, null);
        
        return ResponseEntity.noContent().build(); // Respond with 204 No Content
    }
    @PatchMapping("/artist/{id}/update-flags-streams-payment")
    public ResponseEntity<Void> updateArtistFlagsStreamsPayment(@PathVariable Long id) {
        // Update flags for Streams, Payment, and RoyaltyContract related to the artist
        streamsRepository.updateFlagByArtistId(id);
        paymentRepository.updateFlagByArtistId(id);
        return ResponseEntity.noContent().build(); // Respond with 204 No Content
    }
    @GetMapping("/manager/{id}")
    public NotificationResponse getManagerNotifications(@PathVariable Long id) {
        NotificationResponse response = new NotificationResponse();

        // Check RoyaltyContract table
        RoyaltyContract royaltyContract = royaltyContractRepository.findTopByManager_ManagerIdAndFlagTrueAndApproached(id, Approach.MANAGERS);
        if (royaltyContract != null) {
            Artists artist = royaltyContract.getArtist();
            if (artist != null) {
                response.setRequest("Artist '" + artist.getStageName() + "' has offered a partnership.");
            }
        }

        return response;
    }
    @PatchMapping("/manager/{id}/update-flags")
    public ResponseEntity<Void> updateManagerFlags(@PathVariable Long id) {
        // Update flags for RoyaltyContract related to the manager
        royaltyContractRepository.updateFlagByArtistIdOrManagerId(null, id);
        
        return ResponseEntity.noContent().build(); // Respond with 204 No Content
    }
}
