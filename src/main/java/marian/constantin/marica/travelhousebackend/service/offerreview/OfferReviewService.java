package marian.constantin.marica.travelhousebackend.service.offerreview;

import marian.constantin.marica.travelhousebackend.model.OfferReview;
import marian.constantin.marica.travelhousebackend.request.offerreview.DeleteOfferReviewRequest;
import marian.constantin.marica.travelhousebackend.request.offerreview.UpdateOfferCommentRequest;
import marian.constantin.marica.travelhousebackend.request.offerreview.UpdateOfferRatingRequest;

import java.util.List;
import java.util.UUID;

public interface OfferReviewService {
    List<OfferReview> getOfferReviewsByOffer(UUID offerId);

    List<OfferReview> getOfferReviewsByTourist(UUID touristId);

    void createOfferReview(OfferReview offerReview);

    boolean updateOfferReviewByRating(UpdateOfferRatingRequest request);

    boolean updateOfferReviewByComment(UpdateOfferCommentRequest request);

    boolean deleteOfferReview(DeleteOfferReviewRequest request);
}
