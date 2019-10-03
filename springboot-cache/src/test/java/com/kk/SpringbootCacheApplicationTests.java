package com.kk;

        import com.google.gson.Gson;
        import com.kk.entity.Employee;
        import com.kk.mapper.EmployeeMapper;
        import net.minidev.json.JSONUtil;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.cache.Cache;
        import org.springframework.cache.annotation.EnableCaching;
        import org.springframework.data.redis.cache.RedisCacheConfiguration;
        import org.springframework.data.redis.cache.RedisCacheManager;
        import org.springframework.data.redis.connection.RedisConnectionFactory;
        import org.springframework.data.redis.core.*;
        import org.springframework.test.context.junit4.SpringRunner;

        import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisCacheManager redisCacheManager;




    @Test
    public void opsValue(){
        ValueOperations<String, String> ssvo = stringRedisTemplate.opsForValue();
        ssvo.set("name","wang");
        ssvo.append("name","junkang");
        String name = ssvo.get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void opsHash(){
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        stringObjectObjectHashOperations.put("hash",1+"","wang");
        stringObjectObjectHashOperations.put("hash",2+"","junkang");
        Object hash = stringObjectObjectHashOperations.get("hash", 1+"");
        System.out.println("hash = " + hash);
    }

    @Test
    public void opsList(){
        Cache name1 = redisCacheManager.getCache("name1");
        name1.put("1",2);
    }
}
