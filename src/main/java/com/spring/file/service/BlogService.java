package com.spring.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.file.model.Blog;
import com.spring.file.repository.BlogRepository;

@Service
public class BlogService implements BlogServiceImpl {

	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public List<Blog> GetAllBlog() {
		// TODO Auto-generated method stub
		return blogRepository.findAll();
	}

	@Override
	public Blog AddBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogRepository.save(blog);
	}

	@Override
	public Blog UpdateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogRepository.save(blog);
	}

	@Override
	public Blog GetBlogId(Blog blog) {
		// TODO Auto-generated method stub
		return blogRepository.save(blog);
	}

	@Override
	public void DeleteId(Integer id) {
		// TODO Auto-generated method stub
		blogRepository.deleteById(id);
		
	}

	@Override
	public Blog fetchBlogEntityByEmailCty(String email_cty) {
		// TODO Auto-generated method stub
		return blogRepository.findByEmailCty(email_cty);
	}
	
	

}
