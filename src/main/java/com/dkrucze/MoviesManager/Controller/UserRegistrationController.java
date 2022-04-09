package com.dkrucze.MoviesManager.Controller;

import com.dkrucze.MoviesManager.Service.UserService;
import com.dkrucze.MoviesManager.Web.Dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/register")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    //FIXME Getting nulls from DTO
    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegistrationDto userRegistrationDto){
        userService.saveUser(userRegistrationDto);
        return "redirect:/api/register?success";
    }
}
