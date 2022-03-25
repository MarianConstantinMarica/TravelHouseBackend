package marian.constantin.marica.travelhousebackend.request.offer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePriceRequest {

    private UUID offerId;
    private Double price;
}
