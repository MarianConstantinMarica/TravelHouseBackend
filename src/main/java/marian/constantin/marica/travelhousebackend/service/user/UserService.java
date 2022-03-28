package marian.constantin.marica.travelhousebackend.service.user;

import marian.constantin.marica.travelhousebackend.model.User;
import marian.constantin.marica.travelhousebackend.request.user.AddPhoneNumberRequest;
import marian.constantin.marica.travelhousebackend.request.user.ChangePasswordRequest;
import marian.constantin.marica.travelhousebackend.request.user.GetUserDetailsRequest;
import marian.constantin.marica.travelhousebackend.response.user.UserDetailsResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDetailsResponse getUserDetails(GetUserDetailsRequest request);

    void register(User user);

    boolean addPhoneNumber(AddPhoneNumberRequest request);

    boolean changePassword(ChangePasswordRequest request);
}
