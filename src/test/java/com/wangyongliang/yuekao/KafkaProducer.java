package com.wangyongliang.yuekao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.wangyongliang.entity.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-beans.xml", "classpath:spring-kafka-producer.xml" })
public class KafkaProducer {
	@Resource
	private KafkaTemplate<String , String> kafkaTemplate;
	@Resource
	private RedisTemplate<String , Article> redisTemplate;
	
	@Test
	public void sendkafka() {
		ListOperations<String, Article> opsForList = redisTemplate.opsForList();
		
		List<Article> list = opsForList.range("articles", 0, -1);
		for (Article article : list) {
			Gson gson = new Gson();
			
			String json = gson.toJson(article);
			
			kafkaTemplate.sendDefault(json);
		}
		
	}
		
}
