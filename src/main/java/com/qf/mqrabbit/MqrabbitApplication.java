package com.qf.mqrabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableRabbit//开启rabbit注解功能
@SpringBootApplication
public class MqrabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqrabbitApplication.class, args);
    }

}

