package marian.constantin.marica.travelhousebackend.repository;

import marian.constantin.marica.travelhousebackend.model.Offer;
import marian.constantin.marica.travelhousebackend.model.OfferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfferRepository extends JpaRepository<Offer, UUID> {
    boolean existsById(UUID id);

    @Modifying
    @Query("update Offer o set o.title = :title where o.id = :id")
    void updateTitle(UUID id, String title);

    @Modifying
    @Query("update Offer o set o.pricePerNight = :pricePerNight where o.id = :id")
    void updatePrice(UUID id, Double pricePerNight);

    @Modifying
    @Query("update Offer o set o.description = :description where o.id = :id")
    void updateDescription(UUID id, String description);

    @Modifying
    @Query("update Offer o set o.offerType = :offerType where o.id = :id")
    void updateOfferType(UUID id, OfferType offerType);

    void deleteOfferById(UUID id);
}
