package com.wangyongliang.listener;

import javax.annotation.Resource;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.wangyongliang.entity.Article;
import com.wangyongliang.service.ArticleService;
import com.wangyongliang.service.RedisService;

@Component("kafkaConsumerListener")
public class KafkaConsumerListener implements MessageListener<String, String> {

	@Resource
	private ArticleService redisService;
	
	@Resource
	private RedisTemplate<String , Article> redisTemplate;

//	@Resource
//	private ElasticsearchTemplate elasticsearchTemplate;

	/**
	 * 接收消息的方法
	 */
	@Override
	public void onMessage(ConsumerRecord<String, String> record) {

		// 获取value数据
		String value = record.value();

		// 将json字符串转换成article
		Gson gson = new Gson();
		// 第一个参数是json数据，第二参数是要转换成的类的类对象
		Article article = gson.fromJson(value, Article.class);

		
		////必须先存入数据库
		
		// 将article存入mysql数据库
		redisService.insert(article);

		// 将数据发送到elasticsearch
//		IndexQuery query = new IndexQueryBuilder().withId(article.getId().toString()).withObject(article).build();
//		
//		elasticsearchTemplate.index(query);

		System.out.println("${"+article.getTitle()+"}已导入完毕");
		
		System.out.println("发送数据库mysql完毕");
		
		redisTemplate.delete("articles");
		
		
	}

}
