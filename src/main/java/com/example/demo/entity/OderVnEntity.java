package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "odervn")
public class OderVnEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id ;
	    private String departureDay ;
	    private String phoneNumber;
	    private Date bookingDate;
	    private int amount;
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private UserEntity user_id;
	    @ManyToOne
	    @JoinColumn(name = "motel_id")
	    private BlogVNE motel_id ;
	    private boolean is_Delete;

	    
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
		public UserEntity getUser_id() {
			return user_id;
		}
		public void setUser_id(UserEntity user_id) {
			this.user_id = user_id;
		}
		public BlogVNE getMotel_id() {
			return motel_id;
		}
		public void setMotel_id(BlogVNE motel_id) {
			this.motel_id = motel_id;
		}
		public boolean isIs_Delete() {
			return is_Delete;
		}
		public void setIs_Delete(boolean is_Delete) {
			this.is_Delete = is_Delete;
		}
		
}
