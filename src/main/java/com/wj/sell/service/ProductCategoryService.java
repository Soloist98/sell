package com.wj.sell.service;

import com.wj.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
