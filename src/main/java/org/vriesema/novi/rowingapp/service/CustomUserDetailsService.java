package org.vriesema.novi.rowingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.model.authentication.Authority;
import org.vriesema.novi.rowingapp.model.authentication.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserService userService;

    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    //TODO Fix code below for own implementation
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password;
        List<GrantedAuthority> grantedAuthorities;
        Optional<User> user = userService.getUser(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        password = user.get().getPassword();
        Set<Authority> authorities = user.get().getAuthorities();
        grantedAuthorities = new ArrayList<>();

        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);

    }
}
