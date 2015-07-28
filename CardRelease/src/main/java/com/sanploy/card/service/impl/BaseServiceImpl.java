package com.sanploy.card.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

import com.sanploy.card.dao.IBaseDao;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;
import com.sanploy.card.service.IBaseService;

@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements IBaseService<T> {

	@SuppressWarnings("rawtypes")
	@Autowired
	public IBaseDao baseDao;

	@Override
	public Serializable save(T model) {
		return baseDao.save(model);
	}

	@Override
	public void update(T model) {
		baseDao.update(model);
	}

	@Override
	public void delete(T model) {
		baseDao.delete(model);
	}

	@Override
	public void deleteAll(List<T> list) {
		baseDao.deleteAll(list);
		;
	}

	@Override
	public void deleteAll(T[] objectArray) {
		baseDao.deleteAll(objectArray);
	}

	@Override
	public void delete(Serializable id) {
		baseDao.delete(id);
	}

	@Override
	public void delete(String hql, Object[] param) {
		baseDao.delete(hql, param);
	}

	@Override
	public void saveOrUpdate(T model) {
		baseDao.saveOrUpdate(model);
	}

	@Override
	public int execte(String hql, Object... paramlist) {
		return baseDao.execte(hql, paramlist);
	}

	@Override
	public void batchUpdate(List<T> list) {
		baseDao.batchUpdate(list);
	}

	@Override
	public T get(Serializable id) {
		return (T) baseDao.get(id);
	}

	@Override
	public T unique(String hql, Object[] param) {
		return (T) baseDao.unique(hql, param);
	}

	@Override
	public List<T> list() {
		return baseDao.list();
	}

	@Override
	public List<T> list(int start, int size, String order) {
		return baseDao.list(start, size, order);
	}

	@Override
	public List<T> list(String condition, Object[] param) {
		return baseDao.list(condition, param);
	}

	@Override
	public List<T> list(String hql, Object[] param, int start, int size, String order) {
		return baseDao.list(hql, param, start, size, order);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page getPage(int currentPage, HqlHelper hqlHelper) {
		return baseDao.getPage(currentPage, hqlHelper);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page getPage(int currentPage, SqlHelper sqlHelper) {
		return baseDao.getPage(currentPage, sqlHelper);
	}

	@Override
	public int count() {
		return baseDao.count();
	}

	@Override
	public int count(String hql, Object[] param) {
		return baseDao.count(hql, param);
	}

	@Override
	public List<T> criteriaList(Criteria criteria, int start, int size, String order) {
		return baseDao.criteriaList(criteria, start, size, order);
	}

	@Override
	public String getLimitString(String sql, int start, int size) {
		return baseDao.getLimitString(sql, start, size);
	}

	@Override
	public boolean isExists(Object propertyName, Serializable property) {
		return baseDao.isExists(propertyName, property);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getObject(String hql, Object[] param) {
		return baseDao.getObject(hql, param);
	}
}
