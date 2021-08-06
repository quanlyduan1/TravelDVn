package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BlogVNE;

@Repository
public interface BlogVNDao extends JpaRepository<BlogVNE,Integer> {

}
