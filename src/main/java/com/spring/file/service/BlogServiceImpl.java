package com.spring.file.service;

import java.util.List;

import com.spring.file.model.Blog;

public interface BlogServiceImpl {
	
	List<Blog>GetAllBlog();
	Blog AddBlog(Blog blog);
	Blog UpdateBlog(Blog blog);
	Blog GetBlogId(Blog blog);
	Blog fetchBlogEntityByEmailCty(String email_cty);
	void DeleteId(Integer id);

	

}
