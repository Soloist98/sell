package com.wj.sell.service.impl;

import com.wj.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private  ProductCategoryServiceImpl productCategoryService;
    @Test
    public void findOne() {
        ProductCategory result = productCategoryService.findOne(1);
        Assert.assertEquals(new Integer(1), result.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> result = productCategoryService.findAll();
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> result = productCategoryService.findByCategoryTypeIn(Arrays.asList(2, 2));
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("wangjun", 777);
        ProductCategory result = productCategoryService.save(productCategory);
        Assert.assertEquals(productCategory, result);
    }
}