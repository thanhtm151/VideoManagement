package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.USERS;
import com.poly.entity.USERS;
import com.poly.util.JpaUtils;

public class UserDAO {
	private EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
	public USERS create(USERS entity) {
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
	public USERS update(USERS entity) {
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
	public USERS remove(String id) {
		USERS entity = this.findById(id);
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
	public USERS findById(String id) {
		USERS entity = em.find(USERS.class, id);
		return entity;
	}
	public List<USERS> findAll() {
		String jsql = "FROM USERS";
		TypedQuery<USERS> query = em.createQuery(jsql,USERS.class);
		List<USERS> list = query.getResultList();
		return list;
	}
}
