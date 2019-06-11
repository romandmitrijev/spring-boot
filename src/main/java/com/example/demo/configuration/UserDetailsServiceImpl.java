package com.example.demo.configuration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s.equals("admin"))
            return User.builder()
                    .username("admin")
                    .password("admin")
                    .roles("ADMIN")
                    .build();
        if (s.equals("user"))
            return User.builder()
                    .username("user")
                    .password("password")
                    .roles("USER")
                    .build();

        throw new UsernameNotFoundException("No such user");
    }
}
