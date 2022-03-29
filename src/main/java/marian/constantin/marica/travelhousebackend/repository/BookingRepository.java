package marian.constantin.marica.travelhousebackend.repository;

import marian.constantin.marica.travelhousebackend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
    List<Booking> findAllByOfferId(UUID offerId);

    List<Booking> findAllByTouristId(UUID touristId);

    @Modifying
    @Query("update Booking b set b.approved = :approval where b.id = :id")
    void updateApproved(UUID id, boolean approval);

    @Modifying
    @Query("update Booking b set b.cancelBooking = :cancelBooking where b.id = :id")
    void updateCancelBooking(UUID id, boolean cancelBooking);
}
