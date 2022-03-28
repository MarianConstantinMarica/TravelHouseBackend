package marian.constantin.marica.travelhousebackend.request.offerreview;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marian.constantin.marica.travelhousebackend.model.Rating;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateOfferRatingRequest {

    private UUID id;
    private Rating rating;
}
