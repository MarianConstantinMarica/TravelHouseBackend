package marian.constantin.marica.travelhousebackend.service.touristreview;

import marian.constantin.marica.travelhousebackend.model.TouristReview;
import marian.constantin.marica.travelhousebackend.response.touristreview.StatsResponse;

import java.util.UUID;

public interface TouristReviewService {
    StatsResponse getStatsByTourist(UUID id);

    void addTouristReview(TouristReview touristReview);
}
