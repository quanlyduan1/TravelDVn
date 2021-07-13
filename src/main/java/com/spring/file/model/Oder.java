package com.spring.file.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oder")
public class Oder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String customer;
	private String nameBlog;
	private String amountOfpeople;
	private String money;
	private String dateBooking;
	private String phoneNumber;
	private String tourDate;
	
	
	public String getTourDate() {
		return tourDate;
	}
	public void setTourDate(String tourDate) {
		this.tourDate = tourDate;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameBlog() {
		return nameBlog;
	}
	public void setNameBlog(String nameBlog) {
		this.nameBlog = nameBlog;
	}
	public String getAmountOfpeople() {
		return amountOfpeople;
	}
	public void setAmountOfpeople(String amountOfpeople) {
		this.amountOfpeople = amountOfpeople;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getDateBooking() {
		return dateBooking;
	}
	public void setDateBooking(String dateBooking) {
		this.dateBooking = dateBooking;
	}
	
	
	

}
