package org.vriesema.novi.rowingapp.service;
/*
 * @created:  2021-07-03
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.stereotype.Service;
import org.vriesema.novi.rowingapp.model.Authority;
import org.vriesema.novi.rowingapp.model.User;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public String createUser(User user) {
        return null;
    }

    @Override
    public void updateUser(String username, User user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public Collection<User> getUsers() {
        return null;
    }

    @Override
    public Optional<User> getUser(String username) {
        return Optional.empty();
    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public Set<Authority> getAuthorities(String username) {
        return null;
    }

    @Override
    public void addAuthority(String username, String authority) {

    }

    @Override
    public void removeAuthority(String username, String authority) {

    }
}
