package com.able.product;

import com.able.product.common.DecreaseStockInput;
import com.able.product.common.ProductInfoOutput;
import com.able.product.mapper.ProductInfoMapper;
import com.able.product.model.ProductCategory;
import com.able.product.model.ProductInfo;
import com.able.product.repository.ProductCategoryRepository;
import com.able.product.repository.ProductInfoRepository;
import com.able.product.service.ProductService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductApplicationTests {

    @Resource
    ProductInfoMapper productInfoMapper;

    @Resource
    ProductInfoRepository productInfoRepository;
    @Resource
    ProductCategoryRepository productCategoryRepository;

    @Resource
    ProductService productService;
    @Test
    public void contextLoads() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductStatus(0);
        List<ProductInfo> select = productInfoMapper.select(productInfo);
        log.info("select={}",select);
    }

    @Test
    public void test1(){
        List<ProductInfo> productInfoByProductStatus = productInfoRepository.findProductInfoByProductStatus(0);
        log.info("result={}",productInfoByProductStatus);
    }

    @Test
    public void test2(){
        List<ProductCategory> productCategoriesByCategoryTypeIn = productCategoryRepository.findProductCategoriesByCategoryTypeIn(Arrays.asList(11, 12));
        log.info("productCategoriesByCategoryTypeIn={}",productCategoriesByCategoryTypeIn);
    }

    @Test
    public void test3(){
        List<ProductInfoOutput> list = productService.findList(Arrays.asList("157875196366160022", "164103465734242707"));
        System.out.println("list = " + list);
    }





}
