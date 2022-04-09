package com.dkrucze.MoviesManager.Web.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;
}
