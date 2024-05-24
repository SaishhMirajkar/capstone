package com.capstone.AlertCapstone.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

        // Check Payment table
        Payment payment = paymentRepository.findTopByArtist_ArtistIdAndFlagTrue(id);
        if (payment != null) {
            response.setPayout("Your Royalty of " + payment.getPaymentAmount() + " is credited.");
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
}
