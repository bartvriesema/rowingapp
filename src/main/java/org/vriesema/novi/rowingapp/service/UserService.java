package org.vriesema.novi.rowingapp.service;

import org.vriesema.novi.rowingapp.model.authentication.Authority;
import org.vriesema.novi.rowingapp.model.authentication.User;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    String createUser(User user);

    void updateUser(String username, User user);

    void deleteUser(String username);

    Collection<User> getUsers();

    Optional<User> getUser(String username);

    boolean userExists(String username);

    Set<Authority> getAuthorities(String username);

    void addAuthority(String username, String authority);

    void removeAuthority(String username, String authority);

}
