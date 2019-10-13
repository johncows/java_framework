package com.kk.service;

import com.kk.entity.Book;
import org.springframework.amqp.core.Message;

public interface BookService {
     void receive(Book book);
     void receiveMessage(Message message);
}
