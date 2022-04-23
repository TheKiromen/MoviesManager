package com.dkrucze.MoviesManager.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //TODO Create login template
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
