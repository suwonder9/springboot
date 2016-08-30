package cn.su.redis.Impl;

import cn.su.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * Created by sujinxian on 2016/8/22.
 */
@Service
public class RedisServiceImpl implements RedisService{


    @Autowired
    @Qualifier("suScript")
    private RedisScript<Boolean> suScript;

    @Autowired
    @Qualifier("StringScript")
    private RedisScript<String> StringScript;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;




    @Transactional
    public String setProductCount(String num){

        String i = redisTemplate.execute(StringScript,Collections.singletonList(num),"su");
        return i;
    }

    public boolean checkAndSet(String key ,String expectvalue,String newValue){
        return redisTemplate.execute(suScript,Collections.singletonList(key),expectvalue,newValue);
    }



}
