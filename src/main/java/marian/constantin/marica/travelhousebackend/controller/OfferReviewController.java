package marian.constantin.marica.travelhousebackend.controller;

import marian.constantin.marica.travelhousebackend.service.offerreview.OfferReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/offerReview")
public class OfferReviewController {

    private final OfferReviewService offerReviewService;

    @Autowired
    public OfferReviewController(OfferReviewService offerReviewService) {
        this.offerReviewService = offerReviewService;
    }
}
