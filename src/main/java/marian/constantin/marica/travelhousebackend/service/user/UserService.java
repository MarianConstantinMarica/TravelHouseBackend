package marian.constantin.marica.travelhousebackend.service.user;

import marian.constantin.marica.travelhousebackend.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(User user);
}
