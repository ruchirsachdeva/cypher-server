package com.cypher.shopapi.repository;

import com.cypher.shopapi.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Ruchir Sachdeva on 1/2/2019.
 */

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
