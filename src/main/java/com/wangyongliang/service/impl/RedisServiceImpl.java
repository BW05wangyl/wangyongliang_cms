package com.wangyongliang.service.impl;

import javax.annotation.Resource;

import com.wangyongliang.dao.ArticleMapper;
import com.wangyongliang.entity.Article;
import com.wangyongliang.service.RedisService;

public class RedisServiceImpl implements RedisService {

	@Resource
	private ArticleMapper articelMapper;
	@Override
	public void insert(Article article) {
		// TODO Auto-generated method stub
		articelMapper.insert(article);
	}	

}
