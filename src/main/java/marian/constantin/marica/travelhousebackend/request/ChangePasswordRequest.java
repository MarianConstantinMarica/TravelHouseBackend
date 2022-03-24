package marian.constantin.marica.travelhousebackend.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChangePasswordRequest {

    private String email;
    private String oldPassword;
    private String newPassword;
}
