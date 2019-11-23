package com.able.order.config;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @param
 * @author jipeng
 * @date 2019-11-21 20:48
 */
public class MqReceiver {
    @RabbitListener(queuesToDeclare = {@Queue("myqueue")},
    bindings = {@QueueBinding(value = @Queue("queue1"),exchange =@Exchange("exchange"))}
    )
    public void process(String msg){

    }
}

