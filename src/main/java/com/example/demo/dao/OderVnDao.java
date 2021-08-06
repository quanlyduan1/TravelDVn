package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OderVnEntity;
@Repository
public interface OderVnDao extends JpaRepository<OderVnEntity, Integer>  {
	@Query(value="SELECT * FROM comment WHERE is_delete = 0",nativeQuery = true)
	List<OderVnEntity>findAllOder();
	@Query(value="SELECT * FROM comment WHERE motel_id=?1",nativeQuery = true)
	List<OderVnEntity>ListOderByMotel(int motel_id);
}
