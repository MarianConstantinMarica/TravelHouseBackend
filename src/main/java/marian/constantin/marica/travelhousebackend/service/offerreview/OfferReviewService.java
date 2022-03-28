package marian.constantin.marica.travelhousebackend.service.offerreview;

import marian.constantin.marica.travelhousebackend.model.OfferReview;

import java.util.List;
import java.util.UUID;

public interface OfferReviewService {
    List<OfferReview> getOfferReviewsByOffer(UUID offerId);

    List<OfferReview> getOfferReviewsByTourist(UUID touristId);

    void createOfferReview(OfferReview offerReview);
}
