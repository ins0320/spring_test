package com.quiz.lesson02.domain;

import java.util.Date;

public class Store {
	private int id; 
	private String name;
	private String phoneNumber;
	private String address;
	private String businessNumbe;
	private String introduc;
	private Date createdAt;
	private Date updatedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBusinessNumbe() {
		return businessNumbe;
	}
	public void setBusinessNumbe(String businessNumbe) {
		this.businessNumbe = businessNumbe;
	}
	public String getIntroduc() {
		return introduc;
	}
	public void setIntroduc(String introduc) {
		this.introduc = introduc;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
