package com.spring.file.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.file.model.CommentEntity;
import com.spring.file.model.CommentRequest;
import com.spring.file.repository.BlogRepository;
import com.spring.file.repository.CommentDao;
import com.spring.file.repository.UserRepository;

@Service
public class CommentServicelmpl implements CommentService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<CommentEntity> GetComment() {
		return commentDao.findAllComment();
	}

	@Override
	public List<CommentEntity> GetCommentByBlog(Integer blog_id) {
		// TODO Auto-generated method stub
		return commentDao.ListCommentByBlog(blog_id);
	}

	@Override
	public CommentEntity CreateComment(CommentRequest commentRequest) {
		CommentEntity entity = new  CommentEntity();
		Date date = new java.util.Date();
		entity.setComment(commentRequest.getComment());
		entity.setDatecomment(date);
		entity.setUser_id(userRepository.findByEmailId(commentRequest.getEmail()));
		entity.setBlog_id(blogRepository.findById(commentRequest.getBlog_id()).orElseThrow());
		return commentDao.save(entity);
	}

	@Override
	public CommentEntity GetCommentById(CommentEntity commentEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentEntity UpdateComment(CommentRequest commentRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentEntity DeleteComment(Integer id) {
		return null;
	}

}
