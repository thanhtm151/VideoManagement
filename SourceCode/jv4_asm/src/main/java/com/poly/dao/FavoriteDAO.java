package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.FAVORITE;
import com.poly.entity.USERS;
import com.poly.entity.VIDEO;
import com.poly.util.JpaUtils;

public class FavoriteDAO {
	EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	public FAVORITE create(FAVORITE entity) {
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

	public FAVORITE update(FAVORITE entity) {
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

	public FAVORITE remove(Long id) {
		FAVORITE entity = this.findById(id);
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

	public FAVORITE findById(Long id) {
		FAVORITE entity = em.find(FAVORITE.class, id);
		return entity;
	}

	public List<FAVORITE> findAll() {
		String jsql = "FROM FAVORITE";
		TypedQuery<FAVORITE> query = em.createQuery(jsql, FAVORITE.class);
		List<FAVORITE> list = query.getResultList();
		return list;
	}
	public List<String> findAllLike() {
		String jsql = "SELECT o.video.title FROM FAVORITE o GROUP BY o.video.title";
		TypedQuery<String> query = em.createQuery(jsql, String.class);
		List<String> list = query.getResultList();
		return list;
	}

	public List<VIDEO> findLikeVideo(String id) {
		em.getTransaction().begin();
		String jpql = "SELECT o.video FROM FAVORITE o WHERE o.users.id=:user";
		TypedQuery<VIDEO> query = em.createQuery(jpql, VIDEO.class);
		query.setParameter("user", id);
		List<VIDEO> list = query.getResultList();
		em.getTransaction().commit();
		return list;
	}
	public FAVORITE findLikeUser(String id,String userId) {
		em.getTransaction().begin();
		String jpql = "SELECT o FROM FAVORITE o WHERE o.video.id=:vid and o.users.id=:user";
		TypedQuery<FAVORITE> query = em.createQuery(jpql, FAVORITE.class);
		query.setParameter("vid", id);
		query.setParameter("user", userId);
		FAVORITE list = (FAVORITE) query.getResultList();
		em.getTransaction().commit();
		return list;
	}
	public List<FAVORITE> findLike(String id,String userId) {
		String jpql = "SELECT o FROM FAVORITE o WHERE o.video.id=:vid and o.users.id=:user";
		TypedQuery<FAVORITE> query = em.createQuery(jpql, FAVORITE.class);
		query.setParameter("vid", id);
		query.setParameter("user", userId);
		
		List<FAVORITE> list = query.getResultList();
		return list;
	}
	public List<VIDEO> findByVideo(String id) {
		em.getTransaction().begin();
		String jpql = "SELECT o.video FROM FAVORITE o WHERE o.video.id=:vid";
		TypedQuery<VIDEO> query = em.createQuery(jpql, VIDEO.class);
		query.setParameter("vid", id);
		List<VIDEO> list = query.getResultList();
		em.getTransaction().commit();
		return list;
	}
	public List<Long> getLike(String id) {
		String jpql = "SELECT count(o.video) FROM FAVORITE o WHERE o.video.id=:vid";
		TypedQuery<Long> query = em.createQuery(jpql,Long.class);
		query.setParameter("vid",id);
		List<Long> list = query.getResultList();
		return list;
	}
}
