package com.dkrucze.MoviesManager.Web;

import com.dkrucze.MoviesManager.Service.UserService;
import com.dkrucze.MoviesManager.Web.Dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    //Maps user model in request to specified DTO
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegistrationDto userRegistrationDto){
        userService.saveUser(userRegistrationDto);
        return "redirect:/register?success";
    }
}
