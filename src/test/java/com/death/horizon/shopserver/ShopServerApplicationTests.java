package com.death.horizon.shopserver;

import com.death.horizon.shopserver.mq.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServerApplicationTests {

        @Autowired
        private RedisTemplate redisTemplate;

        @Autowired
        Producer producer;

        @Test
        public void contextLoads() {
                producer.produce();
        }

        @Test
        public void testRedis() {
                redisTemplate.opsForValue().set("testz_key", 123, 60, TimeUnit.SECONDS);
        }

        @Test
        public void getRedis() {
                Object x = redisTemplate.opsForValue().get("testz_key");
                System.out.println(x);
        }
}
