package marian.constantin.marica.travelhousebackend.service.user;

import marian.constantin.marica.travelhousebackend.model.User;
import marian.constantin.marica.travelhousebackend.repository.UserRepository;
import marian.constantin.marica.travelhousebackend.security.PasswordEncoder;
import marian.constantin.marica.travelhousebackend.security.TravelHouseUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userRepository.existsByEmail(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userRepository.findByEmail(username);
        return new TravelHouseUserDetails(user);
    }
}
