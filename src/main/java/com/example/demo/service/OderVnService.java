package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.OderVnEntity;
import com.example.demo.entity.OderVnRequest;

public interface OderVnService {
	List<OderVnEntity>GetOder();
	List<OderVnEntity>GetOderByMotel(Integer motel_id);
	OderVnEntity CreateOder(OderVnRequest oderVnRequest );
	OderVnEntity GetOderById(OderVnEntity oderVnEntity );
	OderVnEntity UpdateOder(OderVnRequest oderVnRequest );
	OderVnEntity DeleteOder(Integer id);
}
