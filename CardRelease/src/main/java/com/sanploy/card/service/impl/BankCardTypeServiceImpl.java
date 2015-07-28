package com.sanploy.card.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.sanploy.card.dao.impl.BankCardTypeDaoImpl;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;
import com.sanploy.card.pojo.BankCardType;
import com.sanploy.card.service.BankCardTypeService;

@Service("bankCardTypeService")
@Transactional
public class BankCardTypeServiceImpl implements BankCardTypeService {

	@Resource(name = "bankCardTypeDao")
	private BankCardTypeDaoImpl bankCardTypeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#save(java.lang.Object)
	 */
	@Override
	public Serializable save(BankCardType model) {
		model.setOperateDate(new Date());
		return bankCardTypeDao.save(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(BankCardType model) {
		bankCardTypeDao.delete(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public void delete(String hql, Object[] param) {
		bankCardTypeDao.delete(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.util.List)
	 */
	@Override
	public void deleteAll(List<BankCardType> list) {
		bankCardTypeDao.deleteAll(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.lang.Object[])
	 */
	@Override
	public void deleteAll(BankCardType[] objectArray) {
		bankCardTypeDao.deleteAll(objectArray);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		bankCardTypeDao.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(BankCardType model) {
		bankCardTypeDao.update(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(BankCardType model) {
		model.setOperateDate(new Date());
		bankCardTypeDao.saveOrUpdate(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#batchUpdate(java.util.List)
	 */
	@Override
	public void batchUpdate(List<BankCardType> list) {
		bankCardTypeDao.batchUpdate(list);
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
		return bankCardTypeDao.getLimitString(sql, start, size);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#execte(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int execte(String hql, Object... paramlist) {
		return bankCardTypeDao.execte(hql, paramlist);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#get(java.io.Serializable)
	 */
	@Override
	public BankCardType get(Serializable id) {
		return bankCardTypeDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#unique(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public BankCardType unique(String hql, Object[] param) {
		return (BankCardType) bankCardTypeDao.unique(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list()
	 */
	@Override
	public List<BankCardType> list() {
		return bankCardTypeDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(int, int,
	 * java.lang.String)
	 */
	@Override
	public List<BankCardType> list(int start, int size, String order) {
		return bankCardTypeDao.list(start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public List<BankCardType> list(String condition, Object[] param) {
		return bankCardTypeDao.list(condition, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String,
	 * java.lang.Object[], int, int, java.lang.String)
	 */
	@Override
	public List<BankCardType> list(String hql, Object[] param, int start, int size, String order) {
		return bankCardTypeDao.list(hql, param, start, size, order);
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
		return bankCardTypeDao.getPage(currentPage, hqlHelper);
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
		return bankCardTypeDao.getPage(currentPage, sqlHelper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#count()
	 */
	@Override
	public int count() {
		return bankCardTypeDao.count();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#count(java.lang.String,
	 * java.lang.Object[])
	 */
	@Override
	public int count(String hql, Object[] param) {
		return bankCardTypeDao.count(hql, param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sanploy.card.service.IBaseService#criteriaList(org.hibernate.Criteria
	 * , int, int, java.lang.String)
	 */
	@Override
	public List<BankCardType> criteriaList(Criteria criteria, int start, int size, String order) {
		return bankCardTypeDao.criteriaList(criteria, start, size, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanploy.card.service.IBaseService#isExists(java.lang.Object,
	 * java.io.Serializable)
	 */
	@Override
	public boolean isExists(Object propertyName, Serializable property) {
		return bankCardTypeDao.isExists(propertyName, property);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getObject(String hql, Object[] param) {
		return bankCardTypeDao.getObject(hql, param);
	}

}
