package com.spring.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.file.model.Talk;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Integer> {

}
