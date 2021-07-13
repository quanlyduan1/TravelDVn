package com.spring.file.service;

import java.util.List;

import com.spring.file.model.CommentEntity;
import com.spring.file.model.CommentRequest;

public interface CommentService {

	List<CommentEntity>GetComment();
	List<CommentEntity>GetCommentByBlog(Integer blog_id);
	CommentEntity CreateComment( CommentRequest commentRequest);
	CommentEntity GetCommentById( CommentEntity commentEntity);
	CommentEntity UpdateComment( CommentRequest commentRequest);
	CommentEntity DeleteComment( Integer id );
}
