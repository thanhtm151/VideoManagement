package com.poly.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="FAVORITE",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"Video","UserId"})
})
public class FAVORITE {
	
	@Id
	@Column(name="ID")@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne @JoinColumn(name="UserId")
	USERS users;
	
	@ManyToOne @JoinColumn(name="Video")
	VIDEO video;
	
	@Column(name="LIKEDATE") @Temporal(TemporalType.DATE)
	Date likeDate = new Date();

	
	
	public FAVORITE() {
	}

	public FAVORITE(Long id, USERS users, VIDEO video, Date likeDate) {
		super();
		this.id = id;
		this.users = users;
		this.video = video;
		this.likeDate = likeDate;
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

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	@Override
	public String toString() {
		return "FAVORITE [id=" + id + ", users=" + users + ", video=" + video + ", likeDate=" + likeDate + "]";
	}
	
}
