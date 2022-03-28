package marian.constantin.marica.travelhousebackend.controller;

import marian.constantin.marica.travelhousebackend.model.TouristReview;
import marian.constantin.marica.travelhousebackend.response.touristreview.StatsResponse;
import marian.constantin.marica.travelhousebackend.service.touristreview.TouristReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/touristReview")
public class TouristReviewController {

    private final TouristReviewService touristReviewService;

    @Autowired
    public TouristReviewController(TouristReviewService touristReviewService) {
        this.touristReviewService = touristReviewService;
    }

    @GetMapping("/getStatsByTourist/{id}")
    public ResponseEntity<StatsResponse> getStatsByTourist(@PathVariable UUID id) {
        return new ResponseEntity<>(touristReviewService.getStatsByTourist(id), HttpStatus.OK);
    }

    @PostMapping("/addTouristReview")
    public ResponseEntity<Void> addTouristReview(@RequestBody TouristReview touristReview) {
        touristReviewService.addTouristReview(touristReview);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
