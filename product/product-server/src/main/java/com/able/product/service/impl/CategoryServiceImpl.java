package com.able.product.service.impl;

import com.able.product.model.ProductCategory;
import com.able.product.repository.ProductCategoryRepository;
import com.able.product.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-09 22:06
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findProductCategoriesByCategoryTypeIn(categoryTypeList);
    }
}
