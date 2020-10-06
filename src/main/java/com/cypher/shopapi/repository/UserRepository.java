package com.cypher.shopapi.repository;


import com.cypher.shopapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created By Ruchir Sachdeva on 3/13/2018.
 */

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
    Collection<User> findAllByRole(String role);

}
