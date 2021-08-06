package com.example.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BlogVNDao;
import com.example.demo.dao.OderVnDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.OderVnEntity;
import com.example.demo.entity.OderVnRequest;
import com.example.demo.service.OderVnService;

@Service
public class OderVnServiceImpl implements OderVnService {

	@Autowired
	private OderVnDao oderVnDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogVNDao blogVNDao;

	@Override
	public List<OderVnEntity> GetOder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OderVnEntity> GetOderByMotel(Integer motel_id) {
		// TODO Auto-generated method stub
		return oderVnDao.ListOderByMotel(motel_id);
	}

	@Override
	public OderVnEntity CreateOder(OderVnRequest oderVnRequest) {
		OderVnEntity entity= new OderVnEntity();
		Date date = new java.util.Date();
		entity.setDepartureDay(oderVnRequest.getDepartureDay());
		entity.setAmount(oderVnRequest.getAmount());
		entity.setPhoneNumber(oderVnRequest.getPhoneNumber());
		entity.setBookingDate(date);
		entity.setIs_Delete(false);
		entity.setUser_id(userDao.findByEmailId(oderVnRequest.getEmail()));
		entity.setMotel_id(blogVNDao.findById(oderVnRequest.getMotel_id()).orElseThrow());
		return oderVnDao.save(entity);
	}

	@Override
	public OderVnEntity GetOderById(OderVnEntity oderVnEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OderVnEntity UpdateOder(OderVnRequest oderVnRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OderVnEntity DeleteOder(Integer id) {
		OderVnEntity oder = oderVnDao.findById(id).orElseThrow();
		oder.setIs_Delete(true);
		return oderVnDao.save(oder);
	}

}
