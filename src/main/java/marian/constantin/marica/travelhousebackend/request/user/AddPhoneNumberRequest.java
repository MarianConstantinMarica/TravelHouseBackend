package marian.constantin.marica.travelhousebackend.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddPhoneNumberRequest {

    private String email;
    private String phoneNumber;
}
