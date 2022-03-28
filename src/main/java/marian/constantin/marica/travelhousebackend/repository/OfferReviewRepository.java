package marian.constantin.marica.travelhousebackend.repository;

import marian.constantin.marica.travelhousebackend.model.OfferReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferReviewRepository extends JpaRepository<OfferReview, UUID> {
    List<OfferReview> findAllByOfferId(UUID offerId);

    List<OfferReview> findAllByUserId(UUID userId);
}
