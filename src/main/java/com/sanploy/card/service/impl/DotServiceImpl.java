package com.sanploy.card.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.sanploy.card.dao.impl.DotDaoImpl;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;
import com.sanploy.card.pojo.Dot;
import com.sanploy.card.service.DotService;

@Service("dotService")
public class DotServiceImpl implements DotService {

	
	@Resource(name="dotDao")
	private DotDaoImpl dotDao;
	
	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#save(java.lang.Object)
	 */
	@Override
	public Serializable save(Dot model) {
		model.setOperateDate(new Date());
		return dotDao.save(model);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Dot model) {
		dotDao.delete(model);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void delete(String hql, Object[] param) {
		dotDao.delete(hql, param);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.util.List)
	 */
	@Override
	public void deleteAll(List<Dot> list) {
		dotDao.deleteAll(list);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.lang.Object[])
	 */
	@Override
	public void deleteAll(Dot[] objectArray) {
		dotDao.deleteAll(objectArray);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		dotDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(Dot model) {
		dotDao.update(model);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Dot model) {
		model.setOperateDate(new Date());
		dotDao.saveOrUpdate(model);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#batchUpdate(java.util.List)
	 */
	@Override
	public void batchUpdate(List<Dot> list) {
		dotDao.batchUpdate(list);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#getLimitString(java.lang.String, int, int)
	 */
	@Override
	public String getLimitString(String sql, int start, int size) {
		return dotDao.getLimitString(sql, start, size);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#execte(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int execte(String hql, Object... paramlist) {
		return dotDao.execte(hql, paramlist);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#get(java.io.Serializable)
	 */
	@Override
	public Dot get(Serializable id) {
		return dotDao.get(id);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#unique(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Dot unique(String hql, Object[] param) {
		return (Dot) dotDao.unique(hql, param);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#list()
	 */
	@Override
	public List<Dot> list() {
		return dotDao.list();
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#list(int, int, java.lang.String)
	 */
	@Override
	public List<Dot> list(int start, int size, String order) {
		return dotDao.list(start, size, order);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<Dot> list(String condition, Object[] param) {
		return dotDao.list(condition, param);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String, java.lang.Object[], int, int, java.lang.String)
	 */
	@Override
	public List<Dot> list(String hql, Object[] param, int start, int size, String order) {
		return dotDao.list(hql, param, start, size, order);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#getPage(int, com.sanploy.card.dao.utils.HqlHelper)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getPage(int currentPage, HqlHelper hqlHelper) {
		return dotDao.getPage(currentPage, hqlHelper);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#getPage(int, com.sanploy.card.dao.utils.SqlHelper)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getPage(int currentPage, SqlHelper sqlHelper) {
		return dotDao.getPage(currentPage, sqlHelper);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#count()
	 */
	@Override
	public int count() {
		return dotDao.count();
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#count(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int count(String hql, Object[] param) {
		return dotDao.count(hql, param);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#criteriaList(org.hibernate.Criteria, int, int, java.lang.String)
	 */
	@Override
	public List<Dot> criteriaList(Criteria criteria, int start, int size, String order) {
		return dotDao.criteriaList(criteria, start, size, order);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#isExists(java.lang.Object, java.io.Serializable)
	 */
	@Override
	public boolean isExists(Object propertyName, Serializable property) {
		return dotDao.isExists(propertyName, property);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getObject(String hql, Object[] param) {
		return dotDao.getObject(hql, param);
	}

}
