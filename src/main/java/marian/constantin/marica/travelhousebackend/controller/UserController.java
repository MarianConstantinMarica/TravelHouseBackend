package marian.constantin.marica.travelhousebackend.controller;

import marian.constantin.marica.travelhousebackend.model.User;
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

    @GetMapping("/authenticated")
    public ResponseEntity<String> authenticationStatus() {
        return new ResponseEntity<>("User successfully authenticated!", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.register(user), HttpStatus.CREATED);
    }
}
