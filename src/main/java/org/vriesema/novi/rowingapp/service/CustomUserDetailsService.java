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

    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password;
        List<GrantedAuthority> grantedAuthorities;
        Optional<User> user = userService.getUser(username);
        if (user.isPresent()) {
            password = user.get().getPassword();
            Set<Authority> authorities = user.get().getAuthorities();
            grantedAuthorities = new ArrayList<>();

            for (Authority authority : authorities) {
                grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
            }
        } else {
            throw new UsernameNotFoundException(username);
        }

        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);

    }
}
