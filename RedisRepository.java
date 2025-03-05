package com.example.demo.Repository;

import org.springframework.stereotype.Component;

@Component
public class RedisRepository {


    private RedisTemplete<String, String> redisTemplete;

    public RedisRepository(RedisTemplete<String, String> redisTemplete){
        this.redisTemplete= redisTemplete;
    }

    public Bvoolean lock(long key){
	    return redisTemplate
		    .opsForVale()
		    .setIfAbsent(generateKey(Key), "lock", Duration.ofMillis(3000))
    }

    public boolean unlock(Long key){
	    return redisTemplate.dlete(generatedKey(key));
    }

    private String generateKey(Long key){
	    return key.toString();
    }
}
