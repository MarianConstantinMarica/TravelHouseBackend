package marian.constantin.marica.travelhousebackend.repository;

import marian.constantin.marica.travelhousebackend.model.OfferReview;
import marian.constantin.marica.travelhousebackend.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfferReviewRepository extends JpaRepository<OfferReview, UUID> {
    List<OfferReview> findAllByOfferId(UUID offerId);

    List<OfferReview> findAllByUserId(UUID userId);

    @Modifying
    @Query("update OfferReview o set o.rating = :rating where o.id = :id")
    void updateRating(UUID id, Rating rating);

    @Modifying
    @Query("update OfferReview o set o.comment = :comment where o.id = :id")
    void updateComment(UUID id, String comment);
}
