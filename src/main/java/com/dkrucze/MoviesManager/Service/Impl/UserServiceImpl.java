package com.dkrucze.MoviesManager.Service.Impl;

import com.dkrucze.MoviesManager.Entity.User;
import com.dkrucze.MoviesManager.Repository.UserRepository;
import com.dkrucze.MoviesManager.Service.UserService;
import com.dkrucze.MoviesManager.Web.Dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    //FIXME fix error
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
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities());
    }

    //TODO Check if roles work
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(){
        LinkedList authorities = new LinkedList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
}
