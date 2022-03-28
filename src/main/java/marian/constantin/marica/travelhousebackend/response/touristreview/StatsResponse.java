package marian.constantin.marica.travelhousebackend.response.touristreview;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatsResponse {

    private UUID id;
    private Integer damage;
    private Integer theft;
    private Double averageCleaning;
}
