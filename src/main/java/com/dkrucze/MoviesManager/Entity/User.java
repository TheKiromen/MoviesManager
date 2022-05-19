package com.dkrucze.MoviesManager.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String authority;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.authority="USER";
    }
}
