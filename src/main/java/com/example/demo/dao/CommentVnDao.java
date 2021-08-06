package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CommentVnEntity;

@Repository
public interface CommentVnDao extends JpaRepository<CommentVnEntity, Integer>{
	@Query(value="SELECT * FROM commentvn WHERE is_delete = 0",nativeQuery = true)
	List<CommentVnEntity>findAllComment();
	
	@Query(value="SELECT * FROM commentvn WHERE motel_id=?1",nativeQuery = true)
	List<CommentVnEntity>ListCommentByMotel(int motel_id);
}
