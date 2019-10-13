package com.kk.service.impl;

import com.kk.entity.Book;
import com.kk.service.BookService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Override
    @RabbitListener(queues = "kk")
    public void receive(Book book) {
        System.out.println("book = " + book);
    }

    @Override
    @RabbitListener(queues="kk.end")
    public void receiveMessage(Message message){
        System.out.println(message.getMessageProperties());
        System.out.println("message.getBody() = " + message.getBody());
    }

}
