package com.sanploy.card.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.sanploy.card.dao.impl.RoleDaoImpl;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;
import com.sanploy.card.pojo.Role;
import com.sanploy.card.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource(name = "roleDao")
	private RoleDaoImpl roleDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#save(java.lang.Object)
	 */
	@Override
	public Serializable save(Role model) {
		return roleDao.save(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Role model) {
		roleDao.delete(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void delete(String hql, Object[] param) {
		roleDao.delete(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.util.List)
	 */
	@Override
	public void deleteAll(List<Role> list) {
		roleDao.deleteAll(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.lang.Object[])
	 */
	@Override
	public void deleteAll(Role[] objectArray) {
		roleDao.deleteAll(objectArray);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		roleDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(Role model) {
		roleDao.update(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Role model) {
		roleDao.saveOrUpdate(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#batchUpdate(java.util.List)
	 */
	@Override
	public void batchUpdate(List<Role> list) {
		roleDao.batchUpdate(list);
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
		return roleDao.getLimitString(sql, start, size);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#execte(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int execte(String hql, Object... paramlist) {
		return roleDao.execte(hql, paramlist);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#get(java.io.Serializable)
	 */
	@Override
	public Role get(Serializable id) {
		return roleDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#unique(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public Role unique(String hql, Object[] param) {
		return (Role) roleDao.unique(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list()
	 */
	@Override
	public List<Role> list() {
		return roleDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(int, int,
	 * java.lang.String)
	 */
	@Override
	public List<Role> list(int start, int size, String order) {
		return roleDao.list(start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public List<Role> list(String condition, Object[] param) {
		return roleDao.list(condition, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String,
	 * java.lang.Object[], int, int, java.lang.String)
	 */
	@Override
	public List<Role> list(String hql, Object[] param, int start, int size, String order) {
		return roleDao.list(hql, param, start, size, order);
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
		return roleDao.getPage(currentPage, hqlHelper);
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
		return roleDao.getPage(currentPage, sqlHelper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#count()
	 */
	@Override
	public int count() {
		return roleDao.count();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#count(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int count(String hql, Object[] param) {
		return roleDao.count(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sanploy.card.service.IBaseService#criteriaList(org.hibernate.Criteria
	 * , int, int, java.lang.String)
	 */
	@Override
	public List<Role> criteriaList(Criteria criteria, int start, int size, String order) {
		return roleDao.criteriaList(criteria, start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#isExists(java.lang.Object,
	 * java.io.Serializable)
	 */
	@Override
	public boolean isExists(Object propertyName, Serializable property) {
		return roleDao.isExists(propertyName, property);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getObject(String hql, Object[] param) {
		return roleDao.getObject(hql, param);
	}

}
