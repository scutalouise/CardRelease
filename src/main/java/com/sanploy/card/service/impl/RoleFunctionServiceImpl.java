package com.sanploy.card.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.sanploy.card.dao.impl.RoleFunctionDaoImpl;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;
import com.sanploy.card.pojo.RoleFunction;
import com.sanploy.card.service.RoleFunctionService;

@Service("roleFunctionService")
public class RoleFunctionServiceImpl implements RoleFunctionService {

	@Resource(name = "roleFunctionDao")
	private RoleFunctionDaoImpl roleFunctionDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#save(java.lang.Object)
	 */
	@Override
	public Serializable save(RoleFunction model) {
		return roleFunctionDao.save(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(RoleFunction model) {
		roleFunctionDao.delete(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void delete(String hql, Object[] param) {
		roleFunctionDao.delete(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.util.List)
	 */
	@Override
	public void deleteAll(List<RoleFunction> list) {
		roleFunctionDao.deleteAll(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.lang.Object[])
	 */
	@Override
	public void deleteAll(RoleFunction[] objectArray) {
		roleFunctionDao.deleteAll(objectArray);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		roleFunctionDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(RoleFunction model) {
		roleFunctionDao.update(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(RoleFunction model) {
		roleFunctionDao.saveOrUpdate(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#batchUpdate(java.util.List)
	 */
	@Override
	public void batchUpdate(List<RoleFunction> list) {
		roleFunctionDao.batchUpdate(list);
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
		return roleFunctionDao.getLimitString(sql, start, size);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#execte(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int execte(String hql, Object... paramlist) {
		return roleFunctionDao.execte(hql, paramlist);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#get(java.io.Serializable)
	 */
	@Override
	public RoleFunction get(Serializable id) {
		return roleFunctionDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#unique(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public RoleFunction unique(String hql, Object[] param) {
		return (RoleFunction) roleFunctionDao.unique(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list()
	 */
	@Override
	public List<RoleFunction> list() {
		return roleFunctionDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(int, int,
	 * java.lang.String)
	 */
	@Override
	public List<RoleFunction> list(int start, int size, String order) {
		return roleFunctionDao.list(start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public List<RoleFunction> list(String condition, Object[] param) {
		return roleFunctionDao.list(condition, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String,
	 * java.lang.Object[], int, int, java.lang.String)
	 */
	@Override
	public List<RoleFunction> list(String hql, Object[] param, int start, int size, String order) {
		return roleFunctionDao.list(hql, param, start, size, order);
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
		return roleFunctionDao.getPage(currentPage, hqlHelper);
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
		return roleFunctionDao.getPage(currentPage, sqlHelper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#count()
	 */
	@Override
	public int count() {
		return roleFunctionDao.count();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#count(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int count(String hql, Object[] param) {
		return roleFunctionDao.count(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sanploy.card.service.IBaseService#criteriaList(org.hibernate.Criteria
	 * , int, int, java.lang.String)
	 */
	@Override
	public List<RoleFunction> criteriaList(Criteria criteria, int start, int size, String order) {
		return roleFunctionDao.criteriaList(criteria, start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#isExists(java.lang.Object,
	 * java.io.Serializable)
	 */
	@Override
	public boolean isExists(Object propertyName, Serializable property) {
		return roleFunctionDao.isExists(propertyName, property);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getObject(String hql, Object[] param) {
		return roleFunctionDao.getObject(hql, param);
	}

	@Override
	public void save(Long roleId, Long[] functionIds, String operator) {
		// 先将roleId对应的所有function删除掉；
		String hql = "delete from RoleFunction where role.roleId = ?";
//		Long[] param = { roleId };
		roleFunctionDao.execte(hql, roleId);
		// 执行保存；
		roleFunctionDao.save(roleId, functionIds, operator);
	}

}
