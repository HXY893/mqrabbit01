package com.qf.mqrabbit.Service;

import com.qf.mqrabbit.pojo.po.book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Service;

import java.awt.print.Book;


@Service
public class BookService {
    @RabbitListener(queues = "hxy")
    public void receive(book book){
        System.out.println("监听到"+book);
    }
}
