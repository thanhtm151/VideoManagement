package com.poly.entity;

import java.util.List;

import javax.persistence.*;

@NamedQueries({
		@NamedQuery(name = "Video.findByKeyword", query = "SELECT DISTINCT o.video FROM FAVORITE o"
				+ " WHERE o.video.title LIKE :keyword"),
		@NamedQuery(name = "Video.findByUser", query = "SELECT o.video FROM FAVORITE o" + " WHERE o.users.id=:id"),
		@NamedQuery(name = "Video.findInRange", query = "SELECT DISTINCT o.video FROM FAVORITE o"
				+ " WHERE o.likeDate BETWEEN :min AND :max"),
//		@NamedQuery(name = "Video.findInMonths", query = "SELECT DISTINCT o.video FROM FAVORITE o"
//				+ " WHERE month(o.likeDate) IN (:months)") 
})
@NamedNativeQueries({
		@NamedNativeQuery(name = "Report.random4", query = "SELECT TOP 4 * FROM VIDEO ORDER BY [views] DESC", resultClass = VIDEO.class),
		@NamedNativeQuery(name = "Report.random42", query = "SELECT TOP 4 * FROM VIDEO ORDER BY [views]", resultClass = VIDEO.class)
})

@Entity
@Table(name = "VIDEO")
public class VIDEO {

	@Id
	@Column(name = "ID")
	String id;

	@Column(name = "TITLE")
	String title;

	@Column(name = "POSTER")
	String poster;

	@Column(name = "VIEWS")
	Integer views = 0;

	@Column(name = "DISCRIPTIONS")
	String discriptions;

	@Column(name = "ACTIVE")
	Boolean active;

	@Column(name = "HREF")
	String href;

//	@OneToMany(mappedBy = "video")
//	List<FAVORITE> favorites;
//
//	@OneToMany(mappedBy = "video")
//	List<SHARES> shares;

	public VIDEO() {
	}

	public VIDEO(String id, String title, String poster, Integer views, String discriptions, Boolean active,
			String href) {
		super();
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.discriptions = discriptions;
		this.active = active;
		this.href = href;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getDiscriptions() {
		return discriptions;
	}

	public void setDiscriptions(String discriptions) {
		this.discriptions = discriptions;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

//	public List<FAVORITE> getFavorites() {
//		return favorites;
//	}
//
//	public void setFavorites(List<FAVORITE> favorites) {
//		this.favorites = favorites;
//	}
//
//	public List<SHARES> getShares() {
//		return shares;
//	}
//
//	public void setShares(List<SHARES> shares) {
//		this.shares = shares;
//	}

}
