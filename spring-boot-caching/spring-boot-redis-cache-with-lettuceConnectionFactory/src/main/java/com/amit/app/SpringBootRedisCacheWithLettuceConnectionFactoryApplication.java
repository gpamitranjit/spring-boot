package com.amit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClusterConnection;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.amit.app.models.User;

@SpringBootApplication
public class SpringBootRedisCacheWithLettuceConnectionFactoryApplication {

	@Bean
	public LettuceConnectionFactory lettuceConnectionFactory() {
		
		RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
		redisClusterConfiguration.addClusterNode(new RedisNode("127.0.0.1", 6001));
		redisClusterConfiguration.addClusterNode(new RedisNode("127.0.0.1", 6002));
		redisClusterConfiguration.addClusterNode(new RedisNode("127.0.0.1", 6003));
		redisClusterConfiguration.addClusterNode(new RedisNode("127.0.0.1", 6004));
		redisClusterConfiguration.addClusterNode(new RedisNode("127.0.0.1", 6005));
		redisClusterConfiguration.addClusterNode(new RedisNode("127.0.0.1", 6006));
		
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisClusterConfiguration);
		return lettuceConnectionFactory;
	}
	
	@Bean
	public RedisTemplate<String, User> redisTemplate() {
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(lettuceConnectionFactory());
		return redisTemplate;
	} 
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisCacheWithLettuceConnectionFactoryApplication.class, args);
	}

}
