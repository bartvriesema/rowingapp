package org.vriesema.novi.rowingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.exceptions.AuthorityNotFoundException;
import org.vriesema.novi.rowingapp.exceptions.RecordNotFoundException;
import org.vriesema.novi.rowingapp.exceptions.UsernameNotFoundException;
import org.vriesema.novi.rowingapp.model.authentication.Authority;
import org.vriesema.novi.rowingapp.model.authentication.User;
import org.vriesema.novi.rowingapp.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements org.vriesema.novi.rowingapp.service.UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }

    @Override
    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    @Override
    public String createUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getUsername();
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public void updateUser(String username, User newUser) {
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isEmpty()) throw new RecordNotFoundException();
        User user = optionalUser.get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    @Override
    public Set<Authority> getAuthorities(String username) {
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isEmpty()) throw new UsernameNotFoundException(username);
        User user = optionalUser.get();
        return user.getAuthorities();
    }

    @Override
    public void addAuthority(String username, String authority) {
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isEmpty()) throw new UsernameNotFoundException(username);
        User user = optionalUser.get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    @Override
    public void removeAuthority(String username, String authority) {
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isEmpty()) throw new UsernameNotFoundException(username);
        User user = optionalUser.get();
        Optional<Authority> found = Optional.empty();

        for (Authority a : user.getAuthorities()) {
            if (a.getAuthority().equalsIgnoreCase(authority)) {
                found = Optional.of(a);
                break;
            }
        }
        if (found.isEmpty()) throw new AuthorityNotFoundException(username);
        Authority authorityToRemove = found.get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }
}
