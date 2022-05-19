package com.dkrucze.MoviesManager.Service;

import com.dkrucze.MoviesManager.Entity.User;
import com.dkrucze.MoviesManager.Web.Dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    User saveUser(UserRegistrationDto registrationDto);
}
