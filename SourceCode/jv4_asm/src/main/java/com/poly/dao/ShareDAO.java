package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.SHARES;
import com.poly.entity.VIDEO;
import com.poly.util.JpaUtils;

public class ShareDAO {
	EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public SHARES create(SHARES entity) {
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
	public SHARES update(SHARES entity) {
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
	public SHARES remove(String id) {
		SHARES  entity = this.findById(id);
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
	public SHARES findById(String id) {
		SHARES  entity = em.find(SHARES .class, id);
		return entity;
	}
	public List<SHARES> findAll() {
		String jsql = "FROM SHARE";
		TypedQuery<SHARES> query = em.createQuery(jsql,SHARES .class);
		List<SHARES> list = query.getResultList();
		return list;
	}
	public List<VIDEO> findShareUser(String id){
		em.getTransaction().begin();
		String jpql = "SELECT o.video FROM SHARES o WHERE o.users.id=:user";
		TypedQuery<VIDEO> query = em.createQuery(jpql, VIDEO.class);
		query.setParameter("user", id);
		List<VIDEO> list = query.getResultList();
		em.getTransaction().commit();
		return list;
	}
	public List<VIDEO> findShareVideo(String id){
		em.getTransaction().begin();
		String jpql = "SELECT o.video FROM SHARES o WHERE o.video.id=:vd";
		TypedQuery<VIDEO> query = em.createQuery(jpql, VIDEO.class);
		query.setParameter("vd", id);
		List<VIDEO> list = query.getResultList();
		em.getTransaction().commit();
		return list;
	}
}
