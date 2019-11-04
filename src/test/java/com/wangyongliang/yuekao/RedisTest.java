package com.wangyongliang.yuekao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wangyongliang.FileUtil;
import com.wangyongliang.entity.Article;
import com.wangyongliang.entity.Category;
import com.wangyongliang.entity.Channel;
import com.wangyongliang.service.CategoryService;
import com.wangyongliang.service.ChannelService;
import com.wangyongliang.utils.RandomUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-beans.xml" })
public class RedisTest {
	@Resource
	private ChannelService channelService;
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private RedisTemplate<String , Article> redisTemplate;
	
	@Test
	public void  SendRedis() throws IOException {
		List<Article> arrayList = new ArrayList<Article>();
		List<String> fileList = FileUtil.getFileList("D:\\1705DJsoup");
		
		for (String filename : fileList) {
			String content = FileUtil.readFile(filename);
			
			String title = filename.substring(filename.lastIndexOf("\\") + 1, filename.lastIndexOf("."));
			
			Article article = new Article();
			
			article.setTitle(title);
			article.setContent(content);
			
			if (content.length()<=140) {
				article.setRemark(content);
			}else {
				article.setRemark(content.substring(0,140));
			}
			Random random = new Random();
			article.setHits(random.nextInt(10000));
			article.setHot(random.nextInt(2));
			article.setUserId(36);
			List<Channel> channels = channelService.getChannels();

			Channel channel = channels.get(random.nextInt(channels.size()));
			article.setChannelId(channel.getId());
			
			List<Category> categories = categoryService.getCategoryByChId(channel.getId());

			if (categories != null && categories.size() > 0) {
				
				Category category = categories.get(random.nextInt(categories.size()));

				article.setCategoryId(category.getId());
			}
			
			Date created = RandomUtil.randomDate("2019-01-01", "2019-10-30");
			article.setCreated(created);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(created);

			calendar.add(Calendar.HOUR, 8);
			Date updated = calendar.getTime();
			article.setUpdated(updated);

			article.setStatus(1);

			article.setPicture("6.jpg");

			arrayList.add(article);
			
		}
		
		ListOperations<String, Article> opsForList = redisTemplate.opsForList();
		opsForList.rightPushAll("articles", arrayList);
		
		System.out.println("发送完毕");
	}
}
