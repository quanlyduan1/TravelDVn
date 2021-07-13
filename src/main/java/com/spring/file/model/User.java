package com.spring.file.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String userName ;
    private String emailId ;
    private String password ;
//    private int role ;
    private String phone;
    private String avatar ;
    private String dateOfBirth;
    private String adsress;
    private String nationality;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role_id;
    
	public Roles getRole_id() {
		return role_id;
	}
	public void setRole_id(Roles role_id) {
		this.role_id = role_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAdsress() {
		return adsress;
	}
	public void setAdsress(String adsress) {
		this.adsress = adsress;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
    
    

    
}
