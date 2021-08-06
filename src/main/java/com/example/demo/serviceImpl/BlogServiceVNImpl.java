package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BlogVNDao;
import com.example.demo.entity.BlogVNE;
import com.example.demo.service.BlogVNService;

@Service
public class BlogServiceVNImpl implements BlogVNService {
	
	@Autowired
	private BlogVNDao blogVNDao;

	@Override
	public List<BlogVNE> GetAllBlogVN() {
		return blogVNDao.findAll();
	}

	@Override
	public BlogVNE AddBlog(BlogVNE blogvne) {
		return blogVNDao.save(blogvne);
	}

	@Override
	public BlogVNE UpdateBlog(BlogVNE blogvne) {
		return blogVNDao.save(blogvne);
	}

	@Override
	public BlogVNE GetBlogId(BlogVNE blogvne) {
		return blogVNDao.save(blogvne);
	}

	@Override
	public void DeleteId(Integer id) {
		 blogVNDao.deleteById(id);
		
	}

}
