package com.able.product.repository;

import com.able.product.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @param
 * @author jipeng
 * @date 2019-11-15 11:20
 */
public interface ProductInfoRepository  extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findProductInfoByProductStatus(Integer productStatus);
}

