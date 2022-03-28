package marian.constantin.marica.travelhousebackend.request.offerreview;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteOfferReviewRequest {

    private UUID id;
}
