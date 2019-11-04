package com.wangyongliang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wangyongliang.entity.Article;
import com.wangyongliang.entity.Channel;
import com.wangyongliang.entity.Link;
import com.wangyongliang.service.ArticleService;
import com.wangyongliang.service.ChannelService;
import com.wangyongliang.utils.ESUtils;
import com.wangyongliang.utils.PageUtil;

@Controller
public class IndexController {
	
	private Logger log = Logger.getLogger(IndexController.class);
	
	@Autowired
	ChannelService cService;
	
	@Autowired
	ArticleService articleService ;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@RequestMapping(value= {"/index","/",""},method=RequestMethod.GET)
	public  String index(HttpServletRequest request,
			 @RequestParam( value="pageSize",defaultValue = "5") Integer pageSize,
			 @RequestParam(value="page",defaultValue = "1") Integer pageNum,
			 @RequestParam(defaultValue = "") String key 
			) {
		
		log.info("this is log test");
		
		List<Channel> channels = cService.getChannels();
		request.setAttribute("channels", channels);
		
		//获取热门
		PageInfo<Article> arPage = null;
		if(key == null || "".equals(key.trim())) {
			arPage = articleService.listhots(key,pageNum, pageSize);
		}else{
			//如果有查询条件，则从elasticsearch中查询数据
			@SuppressWarnings("unchecked")
			AggregatedPage<Article> pageList = (AggregatedPage<Article>) ESUtils.selectObjects(elasticsearchTemplate, Article.class, pageNum - 1, pageSize,
					"id", new String[] {"title"}, key);
			
			//获取查询到的结果
			List<Article> list = pageList.getContent();
			
			//将数据封装到分页对象
			arPage = new PageInfo<Article>(list);
			
			//设置总页数
			arPage.setPages(pageList.getTotalPages());
			
			//设置当前页
			arPage.setPageNum(pageNum);
		}
		
		
		request.setAttribute("pageInfo", arPage);
		
		//获取最新
		List<Article> lastArticles = articleService.last();
		request.setAttribute("lasts", lastArticles);
		List<Article> listCount = articleService.listCount();
		request.setAttribute("listCount", listCount);
		
		List<Article> listHits = articleService.listHits();
		request.setAttribute("listHits", listHits);
		//获取点击量
//		List<Article> hitsArticles = articleService.hit();
//		request.setAttribute("hits", hitsArticles);
		//获取评论数
//		List<Article> lastArticles = articleService.last();
//		request.setAttribute("lasts", lastArticles);
		
		
		//友情链接
		List<Link> links =  new ArrayList<Link>();
		links.add(new Link("http://www.bwie.net","八维招生官网"));
		links.add(new Link("http://www.bwie.org","北京八维官网"));
		links.add(new Link("http://www.bwie.com","北京八维教育"));
		request.setAttribute("links", links);
		
		String pageString = PageUtil.page(arPage.getPageNum(), arPage.getPages(), "/article/hots?key="+key, arPage.getPageSize());
		request.setAttribute("pageStr", pageString);
		return "index/index";
	}
	
}
