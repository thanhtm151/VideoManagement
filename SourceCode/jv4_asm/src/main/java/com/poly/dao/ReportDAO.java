package com.poly.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poly.entity.FAVORITE;
import com.poly.entity.REPORT;
import com.poly.entity.SHARES;
import com.poly.entity.USERS;
import com.poly.entity.VIDEO;
import com.poly.util.JpaUtils;


public class ReportDAO {
	EntityManager em = JpaUtils.getEntityManager();
	public ReportDAO() {
		// TODO Auto-generated constructor stub
	}
//	public List<Integer> selectYear() {
//		String jpql = "SELECT year(o.likeDate) FROM Favorite o GROUP BY year(o.likeDate)";
//		TypedQuery<Integer> query = em.createQuery(jpql, Integer.class);
//		List<Integer> list = query.getResultList();
//		return list;
//	}


	public List<REPORT> favoriteReport() {
		String jpql = "SELECT new REPORT(o.video.title, count(o), max(o.likeDate), min(o.likeDate)) FROM FAVORITE o GROUP BY o.video.title";
		TypedQuery<REPORT> query = em.createQuery(jpql,REPORT.class);
		List<REPORT> list = query.getResultList();
		return list;
	}
	
	public List<FAVORITE> favoritesUserReport(HttpServletRequest request) {
		String keyword = request.getParameter("title1");
		String jpql = "SELECT DISTINCT o FROM FAVORITE o WHERE o.video.title LIKE :keyword";
		TypedQuery<FAVORITE> query = em.createQuery(jpql, FAVORITE.class);
		query.setParameter("keyword", "%" + keyword + "%");
		List<FAVORITE> list = query.getResultList();
		return list;
	}
	
	public List<SHARES> shareReport(HttpServletRequest request){
		String keyword = request.getParameter("title2");
		String jpql = "SELECT DISTINCT o FROM SHARES o WHERE o.video.title LIKE :keyword";
		TypedQuery<SHARES> query = em.createQuery(jpql, SHARES.class);
		query.setParameter("keyword", "%" + keyword + "%");
		List<SHARES> list = query.getResultList();
		return list;
	}
	
	public List<Long> getCountUser(){
		String jpql = "SELECT count(o) FROM USERS o";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		List<Long> list = query.getResultList();
		
		return list;
	}
	public List<Long> getCountVideo(){
		String jpql = "SELECT count(o) FROM VIDEO o";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		List<Long> list = query.getResultList();
		
		return list;
	}
	public List<Long> getCountViews(){
		String jpql = "SELECT sum(o.views) FROM VIDEO o";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		List<Long> list = query.getResultList();
		
		return list;
	}
	
	public List<Long> getLikeCount() {
		String jpql = "SELECT count(o) FROM FAVORITE o";
		TypedQuery<Long> query = em.createQuery(jpql,Long.class);
		List<Long> list = query.getResultList();
		return list;
	}
	

}
