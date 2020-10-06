package com.cypher.shopapi.service;

import com.cypher.shopapi.entity.Cart;
import com.cypher.shopapi.entity.ProductInOrder;
import com.cypher.shopapi.entity.User;

import java.util.Collection;

/**
 * Created By Ruchir Sachdeva on 3/10/2018.
 */
public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
