package com.dkrucze.MoviesManager.Service.Impl;

import com.dkrucze.MoviesManager.Entity.User;
import com.dkrucze.MoviesManager.Repository.UserRepository;
import com.dkrucze.MoviesManager.Service.UserService;
import com.dkrucze.MoviesManager.Web.Dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getUsername(),
                            registrationDto.getEmail(),
                            registrationDto.getPassword());

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO
        return null;
    }
}
