package com.qf.mqrabbit;

import com.qf.mqrabbit.pojo.po.book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqrabbitApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;
    /**
     * 单点direct发布
     */
    @Test
    public void contextLoads() {
//        Map<String,Object> map= new HashMap<>();
//        map.put("hello","hxy");
//        map.put("aaa","aaa");
        rabbitTemplate.convertAndSend("exchange.direct","hxy",new book("大哥",123));
    }
    @Test
    public void contextLoads02() {
        Object hxy = rabbitTemplate.receiveAndConvert("hxy");
        System.out.println(hxy.getClass());
        System.out.println(hxy);
    }
    /**
     * fanout
     */
    @Test
    public void contextLoads03() {
        rabbitTemplate.convertAndSend("exchange.fanout","",new book("fanout",234));
    }

    /**
     * 创建路由
     */
    @Test
    public void contextLoads04() {
//        amqpAdmin.declareExchange(new DirectExchange("cr.ccc"));
//        amqpAdmin.declareExchange(new TopicExchange());
//        System.out.println("创建交换器");
//        amqpAdmin.declareQueue(new Queue("qf.mq"));
        amqpAdmin.declareBinding(new Binding("qf.mq",Binding.DestinationType.QUEUE,"cr.ccc","new.hxy",null));
    }
}

