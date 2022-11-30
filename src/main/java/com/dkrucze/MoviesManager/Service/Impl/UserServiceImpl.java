package com.dkrucze.MoviesManager.Service.Impl;

import com.dkrucze.MoviesManager.Entity.User;
import com.dkrucze.MoviesManager.Entity.UserPrincipal;
import com.dkrucze.MoviesManager.Repository.UserRepository;
import com.dkrucze.MoviesManager.Service.UserService;
import com.dkrucze.MoviesManager.Web.Dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User saveUser(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getUsername(),
                            registrationDto.getEmail(),
                            passwordEncoder.encode(registrationDto.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user==null)
            throw new UsernameNotFoundException("Invalid email");
        UserPrincipal principal = new UserPrincipal(user);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword()
                ,principal.getAuthorities());
    }
}
