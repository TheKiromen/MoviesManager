package com.dkrucze.MoviesManager.Service;

import com.dkrucze.MoviesManager.Entity.User;
import com.dkrucze.MoviesManager.Web.Dto.UserRegistrationDto;


public interface UserService {
    User saveUser(UserRegistrationDto registrationDto);
}
