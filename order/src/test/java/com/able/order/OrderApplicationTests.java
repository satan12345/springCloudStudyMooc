package com.able.order;

import com.able.order.mapper.OrderMasterMapper;
import com.able.order.model.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderApplicationTests {

    @Resource
    OrderMasterMapper orderMasterMapper;

    @Test
    public void contextLoads() {
        List<OrderMaster> orderMasters = orderMasterMapper.selectAll();
        log.info("result={}",orderMasters);
    }

}
