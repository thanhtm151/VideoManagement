package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.poly.entity.VIDEO;
import com.poly.util.JpaUtils;

public class VideoDAO {

	EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public VIDEO create(VIDEO entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	public VIDEO update(VIDEO entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	public VIDEO remove(String id) {
		VIDEO entity = this.findById(id);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	public VIDEO findById(String id) {
		VIDEO entity = em.find(VIDEO.class,id);
		return entity;
	}
	public List<VIDEO> findAll() {
		String jsql = "FROM VIDEO";
		TypedQuery<VIDEO> query = em.createQuery(jsql,VIDEO.class);
		List<VIDEO > list = query.getResultList();
		return list;
	}
	public List<VIDEO> findVideoTop5(){
		Query query = em.createNamedQuery("Report.random4");
		List<VIDEO > list = query.getResultList();
		return list;
	}
	public List<VIDEO> findVideoTop(){
		Query query = em.createNamedQuery("Report.random42");
		List<VIDEO > list = query.getResultList();
		return list;
	}
	
	public List<VIDEO> findVideoLike(String id){
		em.getTransaction().begin();
		String jpql = "SELECT o.video FROM FAVORITE o WHERE o.users.id=:user";
		TypedQuery<VIDEO> query = em.createQuery(jpql, VIDEO.class);
		query.setParameter("user", id);
		List<VIDEO> list = query.getResultList();
		em.getTransaction().commit();
		return list;
	}
	
	public List<VIDEO> findVideoShare(String id){
		em.getTransaction().begin();
		String jpql = "SELECT DISTINCT o.video FROM SHARES o WHERE o.users.id=:user";
		TypedQuery<VIDEO> query = em.createQuery(jpql, VIDEO.class);
		query.setParameter("user", id);
		List<VIDEO> list = query.getResultList();
		em.getTransaction().commit();
		return list;
	}
	

}
