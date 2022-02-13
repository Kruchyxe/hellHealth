package pl.kruchyxe.hellhealth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("")
    public String home() {
        return "home";

    }
}
