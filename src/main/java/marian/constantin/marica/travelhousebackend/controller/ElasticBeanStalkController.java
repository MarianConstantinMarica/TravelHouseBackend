package marian.constantin.marica.travelhousebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class ElasticBeanStalkController {

    @GetMapping("/")
    public String verifyAppHealth() {
        return "TravelHouseBackend app is healthy";
    }
}
