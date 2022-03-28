package marian.constantin.marica.travelhousebackend.service.touristreview;

import marian.constantin.marica.travelhousebackend.model.TouristReview;
import marian.constantin.marica.travelhousebackend.repository.TouristReviewRepository;
import marian.constantin.marica.travelhousebackend.response.touristreview.StatsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TouristReviewServiceImpl implements TouristReviewService {

    private final TouristReviewRepository touristReviewRepository;

    @Autowired
    public TouristReviewServiceImpl(TouristReviewRepository touristReviewRepository) {
        this.touristReviewRepository = touristReviewRepository;
    }

    @Override
    public StatsResponse getStatsByTourist(UUID id) {
        List<TouristReview> reviews = touristReviewRepository.findAllByTouristId(id);
        int damage = 0;
        int theft = 0;
        int sumCleaning = 0;
        double averageCleaning;
        for (TouristReview review : reviews) {
            if (review.getDamage()) {
                damage += 1;
            }
            if (review.getTheft()) {
                theft += 1;
            }
            sumCleaning += review.getCleaning().ordinal();
        }
        averageCleaning = (double) sumCleaning / reviews.size();
        return new StatsResponse(id, damage, theft, averageCleaning);
    }

    @Override
    public void addTouristReview(TouristReview touristReview) {
        touristReviewRepository.save(touristReview);
    }
}
