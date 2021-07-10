package org.vriesema.novi.rowingapp.repository;
/*
 * @created:  2021-07-10
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.authentication.User;

public interface UserRepository extends JpaRepository<User, String> {
}
