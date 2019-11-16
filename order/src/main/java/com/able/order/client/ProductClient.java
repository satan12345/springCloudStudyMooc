package com.able.order.client;

import com.able.order.common.DecreaseStockInput;
import com.able.order.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author jipeng
 * @date 2019-11-16 15:06
 * @description
 */
@FeignClient(name = "product")

public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @GetMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
