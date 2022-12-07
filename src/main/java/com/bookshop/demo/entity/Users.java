package com.bookshop.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class Users {

//	@OneToMany(mappedBy = "users")
//	private List<Orders> order;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String fname;
	private String lname;

	@Pattern(regexp = "^[a-zA-z0-9]+@{1}[a-zA-z]+\\.[a-z]+$", message = "Invalid email S")
	private String email;

	@Pattern(regexp = "[0-9]{10}", message = "Invalid phone number")
	private String phoneNo;
	private String password;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
