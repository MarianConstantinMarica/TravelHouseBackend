package marian.constantin.marica.travelhousebackend.repository;

import marian.constantin.marica.travelhousebackend.model.TouristReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TouristReviewRepository extends JpaRepository<TouristReview, UUID> {
    List<TouristReview> findAllByTouristId(UUID id);
}
