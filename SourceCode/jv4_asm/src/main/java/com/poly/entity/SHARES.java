package com.poly.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="SHARES",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"Video","UserId"})
}) 
public class SHARES {

	@Id
	@Column(name="ID") @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne @JoinColumn(name = "UserId")
	USERS users;
	
	@ManyToOne @JoinColumn(name="Video")
	VIDEO video;
	
	@Column(name="EMAIL")
	String email;
	
	@Column(name="SHAREDATE") @Temporal(TemporalType.DATE)
	Date shareDate = new Date();
		
	public SHARES() {

	}

	public SHARES(Long id, USERS users, VIDEO video, String email, Date shareDate) {
		super();
		this.id = id;
		this.users = users;
		this.video = video;
		this.email = email;
		this.shareDate = shareDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public USERS getUser() {
		return users;
	}

	public void setUser(USERS users) {
		this.users = users;
	}

	public VIDEO getVideo() {
		return video;
	}

	public void setVideo(VIDEO video) {
		this.video = video;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

	@Override
	public String toString() {
		return "SHARES [id=" + id + ", users=" + users + ", video=" + video + ", email=" + email + ", shareDate="
				+ shareDate + "]";
	}
	
	
}
