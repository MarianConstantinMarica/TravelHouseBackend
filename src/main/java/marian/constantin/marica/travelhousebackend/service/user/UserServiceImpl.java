package marian.constantin.marica.travelhousebackend.service.user;

import marian.constantin.marica.travelhousebackend.model.User;
import marian.constantin.marica.travelhousebackend.repository.UserRepository;
import marian.constantin.marica.travelhousebackend.request.AddPhoneNumberRequest;
import marian.constantin.marica.travelhousebackend.request.GetUserDetailsRequest;
import marian.constantin.marica.travelhousebackend.response.UserDetailsResponse;
import marian.constantin.marica.travelhousebackend.security.PasswordEncoder;
import marian.constantin.marica.travelhousebackend.security.TravelHouseUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    public UserDetailsResponse getUserDetails(GetUserDetailsRequest request) {
        return UserDetailsResponse.builder()
                .name(userRepository.findByEmail(request.getEmail()).getName())
                .email(userRepository.findByEmail(request.getEmail()).getEmail())
                .phoneNumber(userRepository.findByEmail(request.getEmail()).getPhoneNumber())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userRepository.existsByEmail(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = userRepository.findByEmail(username);
        return new TravelHouseUserDetails(user);
    }

    @Override
    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean addPhoneNumber(AddPhoneNumberRequest request) {
        if (!userRepository.existsByEmail(request.getEmail())) {
            return false;
        }
        userRepository.updatePhoneNumber(request.getEmail(), request.getPhoneNumber());
        return true;
    }
}
