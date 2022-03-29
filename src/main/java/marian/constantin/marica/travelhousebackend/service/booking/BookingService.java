package marian.constantin.marica.travelhousebackend.service.booking;

import marian.constantin.marica.travelhousebackend.model.Booking;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    List<Booking> getBookingsByOffer(UUID offerId);

    List<Booking> getBookingsByTourist(UUID touristId);

    void addBooking(Booking booking);

    boolean approveBooking(UUID id);

    boolean cancelBooking(UUID id);

    boolean deleteBooking(UUID id);
}
