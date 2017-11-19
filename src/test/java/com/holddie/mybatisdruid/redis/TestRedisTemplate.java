package com.holddie.mybatisdruid.redis;

import com.holddie.mybatisdruid.entity.UserEntity;
import com.holddie.mybatisdruid.enums.UserSexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试 Redis 缓存
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/19 18:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString(){
        redisTemplate.opsForValue().set("name","holddie");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    public void testObj(){
        UserEntity userEntity = new UserEntity("holddie","123qwe", UserSexEnum.WOMAN);
        ValueOperations<String, UserEntity> operations = redisTemplate.opsForValue();
        operations.set("com.holddie",userEntity);
        UserEntity userEntity1 = operations.get("com.holddie");
        System.out.println("User:" + userEntity1.toString());
    }
}
