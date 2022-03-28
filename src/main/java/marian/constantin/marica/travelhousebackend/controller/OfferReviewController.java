package marian.constantin.marica.travelhousebackend.controller;

import marian.constantin.marica.travelhousebackend.model.OfferReview;
import marian.constantin.marica.travelhousebackend.request.offerreview.DeleteOfferReviewRequest;
import marian.constantin.marica.travelhousebackend.request.offerreview.UpdateOfferCommentRequest;
import marian.constantin.marica.travelhousebackend.request.offerreview.UpdateOfferRatingRequest;
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

    @GetMapping("/getOfferReviews/byOffer/{offerId}")
    public ResponseEntity<List<OfferReview>> getOfferReviewsByOffer(@PathVariable UUID offerId) {
        return new ResponseEntity<>(offerReviewService.getOfferReviewsByOffer(offerId), HttpStatus.OK);
    }

    @GetMapping("/getOfferReviews/byTourist/{touristId}")
    public ResponseEntity<List<OfferReview>> getOfferReviewsByTourist(@PathVariable UUID touristId) {
        return new ResponseEntity<>(offerReviewService.getOfferReviewsByTourist(touristId), HttpStatus.OK);
    }

    @PostMapping("/createOfferReview")
    public ResponseEntity<Void> createOfferReview(@RequestBody OfferReview offerReview) {
        offerReviewService.createOfferReview(offerReview);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateOfferReviewByRating")
    public ResponseEntity<String> updateOfferReviewByRating(@RequestBody UpdateOfferRatingRequest request) {
        if (offerReviewService.updateOfferReviewByRating(request)) {
            return new ResponseEntity<>("Offer review updated by rating", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateOfferReviewByComment")
    public ResponseEntity<String> updateOfferReviewByComment(@RequestBody UpdateOfferCommentRequest request) {
        if (offerReviewService.updateOfferReviewByComment(request)) {
            return new ResponseEntity<>("Offer review updated by comment", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteOfferReview")
    public ResponseEntity<String> deleteOfferReview(@RequestBody DeleteOfferReviewRequest request) {
        if (offerReviewService.deleteOfferReview(request)) {
            return new ResponseEntity<>("Deleted Offer review", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error on delete", HttpStatus.BAD_REQUEST);
    }
}
