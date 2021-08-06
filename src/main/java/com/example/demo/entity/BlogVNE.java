package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="blogtravel")
public class BlogVNE {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nameTravel;
	private String address;
	private int price;
	private String content;
	private String nation;
	private String image;
	private String dateSubmit;
	
	public BlogVNE() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameTravel() {
		return nameTravel;
	}
	public void setNameTravel(String nameTravel) {
		this.nameTravel = nameTravel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDateSubmit() {
		return dateSubmit;
	}
	public void setDateSubmit(String dateSubmit) {
		this.dateSubmit = dateSubmit;
	}
	
	
}
