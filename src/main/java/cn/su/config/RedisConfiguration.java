package cn.su.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * Created by sujinxian on 2016/8/19.
 */

@Configuration
public class RedisConfiguration {

    @Value("sentinel.masterName")
    private String masterName;

    @Value("sentinel.host")
    private String host;


    @Bean
    public RedisConnectionFactory createRedisConnectionFactory(){

        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration();

        sentinelConfig.master(masterName);

       return new JedisConnectionFactory(sentinelConfig);

    }

    @Bean(name="su")
    public RedisScript<String> deductionProjectBalanceScript(){
        DefaultRedisScript<String> redisScript = new DefaultRedisScript<String>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("/redisscript/su.lua")));
        redisScript.setResultType(String.class);
        return redisScript;
    }

}
