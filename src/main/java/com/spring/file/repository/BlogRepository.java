package com.spring.file.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.file.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

	Blog findByEmailCty(String email_cty);

}
