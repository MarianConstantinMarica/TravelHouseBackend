package marian.constantin.marica.travelhousebackend.controller;

import marian.constantin.marica.travelhousebackend.model.OfferReview;
import marian.constantin.marica.travelhousebackend.request.offer.CreateOfferRequest;
import marian.constantin.marica.travelhousebackend.service.offerreview.OfferReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/offerReview")
public class OfferReviewController {

    private final OfferReviewService offerReviewService;

    @Autowired
    public OfferReviewController(OfferReviewService offerReviewService) {
        this.offerReviewService = offerReviewService;
    }

    @GetMapping("/getOfferReviews/{offerId}")
    public ResponseEntity<List<OfferReview>> getOfferReviewsByOffer(@PathVariable UUID offerId) {
        return new ResponseEntity<>(offerReviewService.getOfferReviewsByOffer(offerId), HttpStatus.OK);
    }

    @GetMapping("/getOfferReviews/{touristId}")
    public ResponseEntity<List<OfferReview>> getOfferReviewsByTourist(@PathVariable UUID touristId) {
        return new ResponseEntity<>(offerReviewService.getOfferReviewsByTourist(touristId), HttpStatus.OK);
    }

    @PostMapping("/createOfferReview")
    public ResponseEntity<Void> createOfferReview(@RequestBody OfferReview offerReview) {
        offerReviewService.createOfferReview(offerReview);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
