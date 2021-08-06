package com.example.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BlogVNDao;
import com.example.demo.dao.CommentVnDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.CommentVnEntity;
import com.example.demo.entity.CommentVnRequest;
import com.example.demo.service.CommentVnService;

@Service
public class CommentVnServicelmpl implements CommentVnService {

	@Autowired
	private BlogVNDao blogVNDao;
	@Autowired
	private UserDao userdao;
	@Autowired
	private CommentVnDao commentDao;
	@Override
	public List<CommentVnEntity> GetComment() {
		
		return commentDao.findAllComment();
	}

	@Override
	public CommentVnEntity CreateComment(CommentVnRequest commentRequest) {
		CommentVnEntity entity= new CommentVnEntity();
		Date date = new java.util.Date();
		entity.setComment(commentRequest.getComment());
		entity.setDatecomment(date);
		entity.setIs_Delete(false);
		entity.setUser_id(userdao.findByEmailId(commentRequest.getEmail()));
		entity.setMotel_id(blogVNDao.findById(commentRequest.getMotel_id()).orElseThrow());
		return commentDao.save(entity);
	}

	@Override
	public CommentVnEntity GetCommentById(CommentVnEntity commentEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentVnEntity UpdateComment(CommentVnRequest commentRequest) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<CommentVnEntity> GetCommentByMotel(Integer motel_id) {
		// TODO Auto-generated method stub
		return commentDao.ListCommentByMotel(motel_id);
	}

	@Override
	public CommentVnEntity DeleteComment(Integer id) {
		CommentVnEntity commentService =commentDao.findById(id).orElseThrow();
		commentService.setIs_Delete(true);
		return commentDao.save(commentService);
	}

}
