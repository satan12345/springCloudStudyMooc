package com.able.product.repository;

import com.able.product.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author jipeng
 * @date 2019-11-15 15:35
 * @description
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findProductCategoriesByCategoryTypeIn(List<Integer> categoryTypeIds);

}
