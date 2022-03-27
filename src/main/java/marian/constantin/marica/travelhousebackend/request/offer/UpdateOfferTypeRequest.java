package marian.constantin.marica.travelhousebackend.request.offer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marian.constantin.marica.travelhousebackend.model.OfferType;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateOfferTypeRequest {

    private UUID offerId;
    private OfferType offerType;
}
