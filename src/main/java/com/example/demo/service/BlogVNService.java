package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BlogVNE;

public interface BlogVNService {

	List<BlogVNE>GetAllBlogVN();
	BlogVNE AddBlog (BlogVNE blogvne);
	BlogVNE UpdateBlog (BlogVNE blogvne);
	BlogVNE GetBlogId (BlogVNE blogvne);
	void DeleteId(Integer id);
}
