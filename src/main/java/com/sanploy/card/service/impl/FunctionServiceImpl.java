package com.sanploy.card.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.sanploy.card.dao.impl.FunctionDaoImpl;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;
import com.sanploy.card.pojo.Function;
import com.sanploy.card.service.FunctionService;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {

	@Resource(name = "functionDao")
	private FunctionDaoImpl functionDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#save(java.lang.Object)
	 */
	@Override
	public Serializable save(Function model) {
		return functionDao.save(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Function model) {
		functionDao.delete(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void delete(String hql, Object[] param) {
		functionDao.delete(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.util.List)
	 */
	@Override
	public void deleteAll(List<Function> list) {
		functionDao.deleteAll(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.lang.Object[])
	 */
	@Override
	public void deleteAll(Function[] objectArray) {
		functionDao.deleteAll(objectArray);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		functionDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(Function model) {
		functionDao.update(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Function model) {
		functionDao.saveOrUpdate(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#batchUpdate(java.util.List)
	 */
	@Override
	public void batchUpdate(List<Function> list) {
		functionDao.batchUpdate(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sanploy.card.service.IBaseService#getLimitString(java.lang.String,
	 * int, int)
	 */
	@Override
	public String getLimitString(String sql, int start, int size) {
		return functionDao.getLimitString(sql, start, size);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#execte(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int execte(String hql, Object... paramlist) {
		return functionDao.execte(hql, paramlist);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#get(java.io.Serializable)
	 */
	@Override
	public Function get(Serializable id) {
		return functionDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#unique(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public Function unique(String hql, Object[] param) {
		return (Function) functionDao.unique(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list()
	 */
	@Override
	public List<Function> list() {
		return functionDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(int, int,
	 * java.lang.String)
	 */
	@Override
	public List<Function> list(int start, int size, String order) {
		return functionDao.list(start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public List<Function> list(String condition, Object[] param) {
		return functionDao.list(condition, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String,
	 * java.lang.Object[], int, int, java.lang.String)
	 */
	@Override
	public List<Function> list(String hql, Object[] param, int start, int size, String order) {
		return functionDao.list(hql, param, start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#getPage(int,
	 * com.sanploy.card.dao.utils.HqlHelper)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getPage(int currentPage, HqlHelper hqlHelper) {
		return functionDao.getPage(currentPage, hqlHelper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#getPage(int,
	 * com.sanploy.card.dao.utils.SqlHelper)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getPage(int currentPage, SqlHelper sqlHelper) {
		return functionDao.getPage(currentPage, sqlHelper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#count()
	 */
	@Override
	public int count() {
		return functionDao.count();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#count(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int count(String hql, Object[] param) {
		return functionDao.count(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sanploy.card.service.IBaseService#criteriaList(org.hibernate.Criteria
	 * , int, int, java.lang.String)
	 */
	@Override
	public List<Function> criteriaList(Criteria criteria, int start, int size, String order) {
		return functionDao.criteriaList(criteria, start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#isExists(java.lang.Object,
	 * java.io.Serializable)
	 */
	@Override
	public boolean isExists(Object propertyName, Serializable property) {
		return functionDao.isExists(propertyName, property);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getObject(String hql, Object[] param) {
		return functionDao.getObject(hql, param);
	}

}
