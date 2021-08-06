package com.example.demo.entity;

import java.util.Date;

public class OderVnRequest {
	private Integer id ;
    private String departureDay ;
    private String phoneNumber;
    private Date bookingDate;
    private int amount;
    private String email;
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Integer user_id;
    private Integer motel_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartureDay() {
		return departureDay;
	}
	public void setDepartureDay(String departureDay) {
		this.departureDay = departureDay;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getMotel_id() {
		return motel_id;
	}
	public void setMotel_id(Integer motel_id) {
		this.motel_id = motel_id;
	}
}
