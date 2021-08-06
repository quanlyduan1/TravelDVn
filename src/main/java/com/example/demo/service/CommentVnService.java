package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CommentVnEntity;
import com.example.demo.entity.CommentVnRequest;

public interface CommentVnService {
	List<CommentVnEntity>GetComment();
	List<CommentVnEntity>GetCommentByMotel(Integer motel_id);
	CommentVnEntity CreateComment(CommentVnRequest commentRequest );
	CommentVnEntity GetCommentById(CommentVnEntity commentEntity );
	CommentVnEntity UpdateComment(CommentVnRequest commentRequest );
	CommentVnEntity DeleteComment(Integer id);
}
