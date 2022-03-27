package marian.constantin.marica.travelhousebackend.service.offerreview;

import marian.constantin.marica.travelhousebackend.repository.OfferReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferReviewServiceImpl implements OfferReviewService {

    private final OfferReviewRepository offerReviewRepository;

    @Autowired
    public OfferReviewServiceImpl(OfferReviewRepository offerReviewRepository) {
        this.offerReviewRepository = offerReviewRepository;
    }
}
