package marian.constantin.marica.travelhousebackend.service.booking;

import marian.constantin.marica.travelhousebackend.model.Booking;
import marian.constantin.marica.travelhousebackend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getBookingsByOffer(UUID offerId) {
        return bookingRepository.findAllByOfferId(offerId);
    }

    @Override
    public List<Booking> getBookingsByTourist(UUID touristId) {
        return bookingRepository.findAllByTouristId(touristId);
    }

    @Override
    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    @Transactional
    @Override
    public boolean approveBooking(UUID id) {
        if (!bookingRepository.existsById(id)) {
            return false;
        }
        bookingRepository.updateApproved(
                id,
                true
        );
        return true;
    }

    @Transactional
    @Override
    public boolean cancelBooking(UUID id) {
        if (!bookingRepository.existsById(id)) {
            return false;
        }
        bookingRepository.updateCancelBooking(
                id,
                true
        );
        return true;
    }

    @Transactional
    @Override
    public boolean deleteBooking(UUID id) {
        if (!bookingRepository.existsById(id)) {
            return false;
        }
        bookingRepository.deleteById(id);
        return true;
    }
}
