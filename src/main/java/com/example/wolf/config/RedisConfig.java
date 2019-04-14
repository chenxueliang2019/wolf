package com.example.wolf.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
//    @Value("${spring.redis.host}")
    private String host = "192.168.1.105";
//    @Value("${spring.redis.port}")
    private int port = 6379;


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //key采用String的序列化方式
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        //value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        //hash的value采用jackson方式序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public JedisPoolConfig getJedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {

        JedisConnectionFactory JedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
        //连接池
        JedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        //IP地址
        JedisConnectionFactory.setHostName(host);
        //端口号
        JedisConnectionFactory.setPort(port);
        //如果Redis设置有密码
        //JedisConnectionFactory.setPassword(password);
        //客户端超时时间单位是毫秒
        JedisConnectionFactory.setTimeout(5000);
        return JedisConnectionFactory;
    }
}
