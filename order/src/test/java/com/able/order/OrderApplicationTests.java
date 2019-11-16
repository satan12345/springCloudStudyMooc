package com.able.order;

import com.able.order.client.ProductClient;
import com.able.order.common.DecreaseStockInput;
import com.able.order.common.ProductInfoOutput;
import com.able.order.enums.OrderStatusEnum;
import com.able.order.enums.PayStatusEnum;
import com.able.order.mapper.OrderDetialMapper;
import com.able.order.mapper.OrderMasterMapper;
import com.able.order.model.OrderDetail;
import com.able.order.model.OrderMaster;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderApplicationTests {

    @Resource
    OrderMasterMapper orderMasterMapper;
    @Resource
    OrderDetialMapper orderDetialMapper;
    @Resource
    LoadBalancerClient loadBalancerClient;
    @Resource
    RestTemplate restTemplate;

    @Resource
    ProductClient productClient;

    @Test
    public void contextLoads() {
        List<OrderMaster> orderMasters = orderMasterMapper.selectAll();
        log.info("result={}",orderMasters);
    }
    @Test
    public void test1(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterMapper.insertSelective(orderMaster);
    }

    @Test
    public void test2(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("234567");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(2);

        int i = orderDetialMapper.insertSelective(orderDetail);
        Assert.assertTrue(i >0);
    }

    @Test
    public void test3(){
        ServiceInstance product = loadBalancerClient.choose("PRODUCT");
        System.out.println("product.getUri() = " + product.getUri());
        System.out.println("product.getHost() = " + product.getHost());
        System.out.println("product.getPort() = " + product.getPort());
//
//        String result = restTemplate.getForObject(product.getUri()+"/msg", String.class);
//        System.out.println("result = " + result);

        String forObject = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        System.out.println("forObject = " + forObject);
    }

    @Test
    public void test4(){
        String result = productClient.productMsg();
        System.out.println("result = " + result);
    }
    
    @Test
    public void test5(){
        List<ProductInfoOutput> productInfoOutputs = productClient.listForOrder(Arrays.asList("157875196366160022", "164103465734242707"));
        System.out.println("productInfoOutputs = " + productInfoOutputs);
    }
    
       
    @Test
    public void test6(){
        productClient.decreaseStock(Lists.newArrayList(new DecreaseStockInput("157875196366160022",3)));
    }


}
