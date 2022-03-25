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
public class UpdateTitleRequest {

    private UUID offerId;
    private String title;
}
