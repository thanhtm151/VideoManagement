package com.poly.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class USERS {
	@Id
	@Column(name="ID")
	String id;
	
	@Column(name="PASSWORDS")
	String password;
	
	@Column(name="EMAIL")
	String email;
	
	@Column(name="FULLNAME")
	String fullname;
	
	@Column(name="ADMIN")
	Boolean admin = false;

	@OneToMany(mappedBy = "users")
	List<FAVORITE> favorites;
	
	@OneToMany(mappedBy = "users")
	List<SHARES> shares;
	
	public USERS() {
	}
	
	public USERS(String id, String password, String email, String fullname, Boolean admin) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.admin = admin;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<FAVORITE> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<FAVORITE> favorites) {
		this.favorites = favorites;
	}

	public List<SHARES> getShares() {
		return shares;
	}

	public void setShares(List<SHARES> shares) {
		this.shares = shares;
	}

	@Override
	public String toString() {
		return "USERS [id=" + id + ", password=" + password + ", email=" + email + ", fullname=" + fullname + ", admin="
				+ admin;
	}
}
