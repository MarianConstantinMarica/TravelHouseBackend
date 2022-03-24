package marian.constantin.marica.travelhousebackend.service.user;

import marian.constantin.marica.travelhousebackend.model.User;
import marian.constantin.marica.travelhousebackend.request.AddPhoneNumberRequest;
import marian.constantin.marica.travelhousebackend.request.ChangePasswordRequest;
import marian.constantin.marica.travelhousebackend.request.GetUserDetailsRequest;
import marian.constantin.marica.travelhousebackend.response.UserDetailsResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDetailsResponse getUserDetails(GetUserDetailsRequest request);

    void register(User user);

    boolean addPhoneNumber(AddPhoneNumberRequest request);

    boolean changePassword(ChangePasswordRequest request);
}
