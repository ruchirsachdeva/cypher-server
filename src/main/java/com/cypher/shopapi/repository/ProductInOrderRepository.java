package com.cypher.shopapi.repository;

import com.cypher.shopapi.entity.ProductInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Ruchir Sachdeva on 3/14/2018.
 */
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}
