package com.kk.config;

import com.kk.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;


@Configuration
public class MyConfiguration {


    @Bean(name = "myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return ( target,  method,  params)->{
            String s = params[0]+"";
            s= "["+s+"]";
            System.out.println("生成的key值为"+s);
            return s;
        };
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object,Employee> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Employee> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Employee.class));
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        boolean b = redisCacheConfiguration.usePrefix();
        System.out.println("b = " + b);
        return RedisCacheManager.builder(redisConnectionFactory).build();
    }

}
