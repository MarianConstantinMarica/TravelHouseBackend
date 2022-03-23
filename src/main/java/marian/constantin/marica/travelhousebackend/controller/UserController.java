package marian.constantin.marica.travelhousebackend.controller;

import marian.constantin.marica.travelhousebackend.model.User;
import marian.constantin.marica.travelhousebackend.request.AddPhoneNumberRequest;
import marian.constantin.marica.travelhousebackend.request.GetUserDetailsRequest;
import marian.constantin.marica.travelhousebackend.response.UserDetailsResponse;
import marian.constantin.marica.travelhousebackend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserDetails")
    public ResponseEntity<UserDetailsResponse> getUserDetails(@RequestBody GetUserDetailsRequest request) {
        return new ResponseEntity<>(userService.getUserDetails(request), HttpStatus.OK);
    }

    @GetMapping("/authenticated")
    public ResponseEntity<String> authenticationStatus() {
        return new ResponseEntity<>("User successfully authenticated!", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid User user) {
        userService.register(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addPhoneNumber")
    public ResponseEntity<String> addPhoneNumber(@RequestBody AddPhoneNumberRequest request) {
        if (!userService.addPhoneNumber(request)) {
            return new ResponseEntity<>("Email not exist", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Phone Number added", HttpStatus.CREATED);
    }
}
