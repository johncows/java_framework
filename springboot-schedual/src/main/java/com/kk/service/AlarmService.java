package com.kk.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlarmService {

    @Scheduled(cron="20 * * * * ?")
    public void  sayHello(){
        System.out.println("ha");
    }
}
