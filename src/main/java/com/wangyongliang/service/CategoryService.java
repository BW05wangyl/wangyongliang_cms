package com.wangyongliang.service;

import java.util.List;

import com.wangyongliang.entity.Category;

public interface CategoryService {

	List<Category> getCategoryByChId(Integer cid);

}
