package marian.constantin.marica.travelhousebackend.controller;

import marian.constantin.marica.travelhousebackend.model.Booking;
import marian.constantin.marica.travelhousebackend.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/getBookingsByOffer/{offerId}")
    public ResponseEntity<List<Booking>> getBookingsByOffer(@PathVariable UUID offerId) {
        return new ResponseEntity<>(bookingService.getBookingsByOffer(offerId), HttpStatus.OK);
    }

    @GetMapping("/getBookingsByTourist/{touristId}")
    public ResponseEntity<List<Booking>> getBookingsByTourist(@PathVariable UUID touristId) {
        return new ResponseEntity<>(bookingService.getBookingsByTourist(touristId), HttpStatus.OK);
    }

    @PostMapping("/addBooking")
    public ResponseEntity<Void> addBooking(@RequestBody Booking booking) {
        bookingService.addBooking(booking);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/approveBooking")
    public ResponseEntity<Void> approveBooking(@RequestBody UUID id) {
        if (bookingService.approveBooking(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/cancelBooking")
    public ResponseEntity<Void> cancelBooking(@RequestBody UUID id) {
        if (bookingService.cancelBooking(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteBooking")
    public ResponseEntity<Void> deleteBooking(@RequestBody UUID id) {
        if (bookingService.deleteBooking(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
