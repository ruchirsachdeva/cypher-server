package com.cypher.shopapi.service;

import com.cypher.shopapi.entity.ProductCategory;

import java.util.List;

/**
 * Created By Ruchir Sachdeva on 3/10/2018.
 */
public interface CategoryService {

    List<ProductCategory> findAll();

    ProductCategory findByCategoryType(Integer categoryType);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
