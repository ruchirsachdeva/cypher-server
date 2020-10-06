package com.cypher.shopapi.service;

import com.cypher.shopapi.entity.ProductInOrder;
import com.cypher.shopapi.entity.User;

/**
 * Created By Ruchir Sachdeva on 1/3/2019.
 */
public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
