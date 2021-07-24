package com.cg.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Logintable")
public class Login {
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	//@OneToOne
	@MapsId
	@JoinColumn(name="cust_id")
	private int loginId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login() {
		super();
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int LoginId) {
		this.loginId = loginId;
	}


	

}