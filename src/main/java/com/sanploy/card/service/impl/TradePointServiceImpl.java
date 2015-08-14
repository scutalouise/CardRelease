package com.sanploy.card.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.sanploy.card.dao.impl.KDLimitDaoImpl;
import com.sanploy.card.dao.impl.TradePointDaoImpl;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;
import com.sanploy.card.pojo.TradePoint;
import com.sanploy.card.service.TradePointService;

@Service("tradePointService")
public class TradePointServiceImpl implements TradePointService {

	@Resource(name = "tradePointDao")
	private TradePointDaoImpl tradePointDao;

	@Resource(name = "kdlimitDao")
	private KDLimitDaoImpl kdlimitDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#save(java.lang.Object)
	 */
	@Override
	public Serializable save(TradePoint model) {
		return tradePointDao.save(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(TradePoint model) {
		tradePointDao.delete(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void delete(String hql, Object[] param) {
		tradePointDao.delete(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.util.List)
	 */
	@Override
	public void deleteAll(List<TradePoint> list) {
		tradePointDao.deleteAll(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.lang.Object[])
	 */
	@Override
	public void deleteAll(TradePoint[] objectArray) {
		tradePointDao.deleteAll(objectArray);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		tradePointDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(TradePoint model) {
		tradePointDao.update(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(TradePoint model) {
		tradePointDao.saveOrUpdate(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#batchUpdate(java.util.List)
	 */
	@Override
	public void batchUpdate(List<TradePoint> list) {
		tradePointDao.batchUpdate(list);
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
		return tradePointDao.getLimitString(sql, start, size);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#execte(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int execte(String hql, Object... paramlist) {
		return tradePointDao.execte(hql, paramlist);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#get(java.io.Serializable)
	 */
	@Override
	public TradePoint get(Serializable id) {
		return tradePointDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#unique(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public TradePoint unique(String hql, Object[] param) {
		return (TradePoint) tradePointDao.unique(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list()
	 */
	@Override
	public List<TradePoint> list() {
		return tradePointDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(int, int,
	 * java.lang.String)
	 */
	@Override
	public List<TradePoint> list(int start, int size, String order) {
		return tradePointDao.list(start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public List<TradePoint> list(String condition, Object[] param) {
		return tradePointDao.list(condition, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String,
	 * java.lang.Object[], int, int, java.lang.String)
	 */
	@Override
	public List<TradePoint> list(String hql, Object[] param, int start, int size, String order) {
		return tradePointDao.list(hql, param, start, size, order);
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
		return tradePointDao.getPage(currentPage, hqlHelper);
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
		return tradePointDao.getPage(currentPage, sqlHelper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#count()
	 */
	@Override
	public int count() {
		return tradePointDao.count();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#count(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int count(String hql, Object[] param) {
		return tradePointDao.count(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sanploy.card.service.IBaseService#criteriaList(org.hibernate.Criteria
	 * , int, int, java.lang.String)
	 */
	@Override
	public List<TradePoint> criteriaList(Criteria criteria, int start, int size, String order) {
		return tradePointDao.criteriaList(criteria, start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#isExists(java.lang.Object,
	 * java.io.Serializable)
	 */
	@Override
	public boolean isExists(Object propertyName, Serializable property) {
		return tradePointDao.isExists(propertyName, property);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getObject(String hql, Object[] param) {
		return tradePointDao.getObject(hql, param);
	}

}
