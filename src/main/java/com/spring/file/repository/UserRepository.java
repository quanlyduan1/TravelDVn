package com.spring.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.file.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
 User findByEmailId(String email_id);
 User findByEmailIdAndPassword(String email_id,String password);
}