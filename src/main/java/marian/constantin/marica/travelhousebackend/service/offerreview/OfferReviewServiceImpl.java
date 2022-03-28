package marian.constantin.marica.travelhousebackend.service.offerreview;

import marian.constantin.marica.travelhousebackend.model.OfferReview;
import marian.constantin.marica.travelhousebackend.repository.OfferReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OfferReviewServiceImpl implements OfferReviewService {

    private final OfferReviewRepository offerReviewRepository;

    @Autowired
    public OfferReviewServiceImpl(OfferReviewRepository offerReviewRepository) {
        this.offerReviewRepository = offerReviewRepository;
    }

    @Override
    public List<OfferReview> getOfferReviewsByOffer(UUID offerId) {
        return offerReviewRepository.findAllByOfferId(offerId);
    }

    @Override
    public List<OfferReview> getOfferReviewsByTourist(UUID touristId) {
        return offerReviewRepository.findAllByUserId(touristId);
    }
}
