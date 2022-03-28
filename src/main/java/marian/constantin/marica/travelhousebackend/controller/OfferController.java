package marian.constantin.marica.travelhousebackend.controller;

import marian.constantin.marica.travelhousebackend.model.Offer;
import marian.constantin.marica.travelhousebackend.request.offer.*;
import marian.constantin.marica.travelhousebackend.service.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/offer")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/getOffers")
    public ResponseEntity<List<Offer>> getOffers() {
        return new ResponseEntity<>(offerService.getOffers(), HttpStatus.OK);
    }

    @PostMapping("/createOffer")
    public ResponseEntity<Void> createOffer(@RequestBody CreateOfferRequest request) {
        offerService.createOffer(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateOfferByTitle")
    public ResponseEntity<String> updateOfferByTitle(@RequestBody UpdateTitleRequest request) {
        if (offerService.updateOfferByTitle(request)) {
            return new ResponseEntity<>("Offer updated by title", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateOfferByPrice")
    public ResponseEntity<String> updateOfferByPrice(@RequestBody UpdatePriceRequest request) {
        if (offerService.updateOfferByPrice(request)) {
            return new ResponseEntity<>("Offer updated by title", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateOfferByDescription")
    public ResponseEntity<String> updateOfferByDescription(@RequestBody UpdateDescriptionRequest request) {
        if (offerService.updateOfferByDescription(request)) {
            return new ResponseEntity<>("Offer updated by description", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateOfferByType")
    public ResponseEntity<String> updateOfferByType(@RequestBody UpdateOfferTypeRequest request) {
        if (offerService.updateOfferByType(request)) {
            return new ResponseEntity<>("Offer updated by type", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteOffer")
    public ResponseEntity<String> deleteOffer(@RequestBody DeleteOfferRequest request) {
        if (offerService.deleteOffer(request)) {
            return new ResponseEntity<>("Deleted Offer", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error on delete", HttpStatus.BAD_REQUEST);
    }
}
