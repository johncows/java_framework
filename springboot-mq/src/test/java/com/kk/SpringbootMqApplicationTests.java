package com.kk;

import com.kk.entity.Book;
import com.rabbitmq.client.impl.AMQImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void sendMessageByDirect() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","王骏康");
        map.put("age","25");
        Book book = new Book();
        book.setAuthor("于谦");
        book.setName("玩儿");
        map.put("book",book);
        rabbitTemplate.convertAndSend("exchange.direct","kk",map);
    }

    @Test
    public void sendMessageByFanout() {
        Book book = new Book();
        book.setAuthor("兰陵笑笑生");
        book.setName("金瓶梅");
        rabbitTemplate.convertAndSend("exchange.fanout","",book);
    }


    @Test
    public void getMessage() {
        Object kk = rabbitTemplate.receiveAndConvert("kk");
        System.out.println("kk = " + kk.getClass());
        System.out.println("kk = " + kk);
    }

    @Test
    public void createQueue(){
        amqpAdmin.declareQueue(new Queue("bookQueue",true));
    }

    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("bookExchange"));
    }

    @Test
    public void binding(){
        amqpAdmin.declareBinding(new Binding("bookQueue",Binding.DestinationType.QUEUE,"bookExchange","book",null));
    }



}
