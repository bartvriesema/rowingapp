package org.vriesema.novi.rowingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.authentication.User;

public interface UserRepository extends JpaRepository<User, String> {
}
