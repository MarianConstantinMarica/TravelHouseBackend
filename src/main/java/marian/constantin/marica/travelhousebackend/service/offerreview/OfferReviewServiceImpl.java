package marian.constantin.marica.travelhousebackend.service.offerreview;

import marian.constantin.marica.travelhousebackend.model.OfferReview;
import marian.constantin.marica.travelhousebackend.repository.OfferReviewRepository;
import marian.constantin.marica.travelhousebackend.request.offerreview.DeleteOfferReviewRequest;
import marian.constantin.marica.travelhousebackend.request.offerreview.UpdateOfferCommentRequest;
import marian.constantin.marica.travelhousebackend.request.offerreview.UpdateOfferRatingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    public void createOfferReview(OfferReview offerReview) {
        offerReviewRepository.save(offerReview);
    }

    @Transactional
    @Override
    public boolean updateOfferReviewByRating(UpdateOfferRatingRequest request) {
        if (!offerReviewRepository.existsById(request.getId())) {
            return false;
        }
        offerReviewRepository.updateRating(
                request.getId(),
                request.getRating()
        );
        return true;
    }

    @Transactional
    @Override
    public boolean updateOfferReviewByComment(UpdateOfferCommentRequest request) {
        if (!offerReviewRepository.existsById(request.getId())) {
            return false;
        }
        offerReviewRepository.updateComment(
                request.getId(),
                request.getComment()
        );
        return true;
    }

    @Transactional
    @Override
    public boolean deleteOfferReview(DeleteOfferReviewRequest request) {
        if (!offerReviewRepository.existsById(request.getId())) {
            return false;
        }
        offerReviewRepository.deleteById(request.getId());
        return true;
    }
}
