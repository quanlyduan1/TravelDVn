package com.spring.file.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String placeName;
	private String location;
	private String companyName;
	private String image1;
//	private String image2;
//	private String image3;
	private String status;
	private String introduce1;
	private String introduce2;
	private String emailCty;
	private String adsressCty;
	private int fareNumber;
	private String letterFare;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
//	public String getImage2() {
//		return image2;
//	}
//	public void setImage2(String image2) {
//		this.image2 = image2;
//	}
//	public String getImage3() {
//		return image3;
//	}
//	public void setImage3(String image3) {
//		this.image3 = image3;
//	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIntroduce1() {
		return introduce1;
	}
	public void setIntroduce1(String introduce1) {
		this.introduce1 = introduce1;
	}
	public String getIntroduce2() {
		return introduce2;
	}
	public void setIntroduce2(String introduce2) {
		this.introduce2 = introduce2;
	}
	public int getFareNumber() {
		return fareNumber;
	}
	public void setFareNumber(int fareNumber) {
		this.fareNumber = fareNumber;
	}
	public String getLetterFare() {
		return letterFare;
	}
	public void setLetterFare(String letterFare) {
		this.letterFare = letterFare;
	}
	public String getEmailCty() {
		return emailCty;
	}
	public void setEmailCty(String emailCty) {
		this.emailCty = emailCty;
	}
	public String getAdsressCty() {
		return adsressCty;
	}
	public void setAdsressCty(String adsressCty) {
		this.adsressCty = adsressCty;
	}
	
	

	
	
}
