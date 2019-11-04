package com.wangyongliang.service;

import java.util.List;

import com.wangyongliang.entity.Article4Vote;
import com.wangyongliang.entity.VoteStatic;

/**
 * 
 * @author wangyongliang
 *
 */
public interface Article4VoteService {
	
	int publish(Article4Vote av);
	
	List<Article4Vote>  list();
	
	Article4Vote  findById(Integer id);
	
	int vote(Integer userId, Integer articleId,Character option);
	
	List<VoteStatic> getVoteStatics(Integer articleId);
	
	
	

}
