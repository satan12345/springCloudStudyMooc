package com.able.order.controller;

import com.able.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @param
 * @author jipeng
 * @date 2019-11-21 21:09
 */
@RestController
public class SendMessageController {

    @Autowired
    StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process(){
        Message<String> build = MessageBuilder.withPayload("now" + new Date()).build();
        boolean send = streamClient.output().send(build);
        System.out.println("send = " + send);
    }
}

