package marian.constantin.marica.travelhousebackend.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetUserDetailsRequest {

    private String email;
}
