package com.qfedu.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.qfedu.persistence.BaseDao;
import com.qfedu.util.HibernateUtil;

public abstract class BaseDaoAdapter<E, K extends Serializable>
		implements BaseDao<E, K> {
	
	private Class<E> entityType;
	private String entityName;
	
	protected BaseDaoAdapter() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityType = (Class<E>) pt.getActualTypeArguments()[0];
		entityName = entityType.getSimpleName();
	}

	@Override
	public K save(E entity) {
		return (K) HibernateUtil.getSession().save(entity);
	}

	@Override
	public boolean deleteById(K id) {
		return HibernateUtil.getSession()
				.createQuery("delete from " + entityName + " as o where o.id=:id")
				.setParameter("id", id)
				.executeUpdate() == 1;
	}

	@Override
	public E update(E entity) {
		return (E) HibernateUtil.getSession().merge(entity);
	}

	@Override
	public E findById(K id) {
		return HibernateUtil.getSession().get(entityType, id);
	}

	@Override
	public List<E> findAll() {
		return HibernateUtil.getSession()
				.createQuery("from " + entityName).getResultList();
	}
}
