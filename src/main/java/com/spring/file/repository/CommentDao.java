package com.spring.file.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.file.model.CommentEntity;

@Repository
public interface CommentDao extends JpaRepository<CommentEntity, Integer> {

	@Query
	List<CommentEntity>findAllComment();
	@Query(value="SELECT * FROM comment WHERE blog_id=?1",nativeQuery = true)
	List<CommentEntity>ListCommentByBlog(int blog_id);
}
