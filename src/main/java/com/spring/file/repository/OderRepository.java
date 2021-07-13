package com.spring.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.file.model.Oder;

@Repository
public interface OderRepository extends JpaRepository<Oder, Integer>{

}
