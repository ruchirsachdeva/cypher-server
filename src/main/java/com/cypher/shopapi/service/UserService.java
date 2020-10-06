package com.cypher.shopapi.service;


import com.cypher.shopapi.entity.User;

import java.util.Collection;

/**
 * Created By Ruchir Sachdeva on 3/13/2018.
 */
public interface UserService {
    User findOne(String email);

    Collection<User> findByRole(String role);

    User save(User user);

    User update(User user);
}
