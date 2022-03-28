package marian.constantin.marica.travelhousebackend.response.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDetailsResponse {

    private String name;
    private String email;
    private String phoneNumber;
}
