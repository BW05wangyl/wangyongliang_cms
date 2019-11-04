package com.wangyongliang.month;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
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
	private RedisTemplate<String, Article> redisTemplate;

	@Test
	public void save() throws IOException {
		
		List<Article> articles = new ArrayList<Article>();
		
		// 读取文件
		// 读取多个文件
		List<String> fileList = FileUtil.getFileList("D:\\1705DJsoup");

		// 读取文件内容
		for (String file_path : fileList) {

			// 获取到文件内容
			String content = FileUtil.readFile(file_path);

			// 获取到文章的名称 将\和.txt去掉
			String title = file_path.substring(file_path.lastIndexOf("\\") + 1, file_path.lastIndexOf("."));

			// 创建实体类对象
			Article article = new Article();

			article.setTitle(title); // 名称
			article.setContent(content); // 内容

//					(4)在文本内容中截取前140个字作为摘要。（2分）
			if (content.length() <= 140) {
				article.setRemark(content);
			} else {
				article.setRemark(content.substring(0, 140));
			}

//					(5)“点击量”和“是否热门”、“频道”字段要使用随机值。（2分）
			Random random = new Random();

			// 点击量
			article.setHits(random.nextInt(10000));

			// 是否热门 0 1
			article.setHot(random.nextInt(2));

			// 频道
			List<Channel> channels = channelService.getChannels();

			// 获取随机频道
			Channel channel = channels.get(random.nextInt(channels.size()));

			article.setChannelId(channel.getId());

			// 分类
			List<Category> categories = categoryService.getCategoryByChId(channel.getId());

			if (categories != null && categories.size() > 0) {
				// 根据随机下标，获取对应的数据
				Category category = categories.get(random.nextInt(categories.size()));

				article.setCategoryId(category.getId());
			}

//			(6)文章发布日期从2019年1月1日模拟到今天。（2分）   -2

			// 随机时间
			Date created = RandomUtil.randomDate("2019-01-01", "2019-10-24");
			article.setCreated(created);

			// 获取8小时以后的时间
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(created);

			calendar.add(Calendar.HOUR, 8);
			Date updated = calendar.getTime();
			article.setUpdated(updated);

//			(7)其它的字段随便模拟。
			article.setStatus(1);

			article.setPicture("8.jpg");
			// 转换成article对象

			articles.add(article);
		}
		
		// 存入redis
		ListOperations<String, Article> opsForList = redisTemplate.opsForList();
		
		opsForList.rightPushAll("articles", articles);
		
		System.out.println("存储完毕");
	}

}
