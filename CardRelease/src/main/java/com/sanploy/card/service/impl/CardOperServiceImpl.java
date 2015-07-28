package com.sanploy.card.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.sanploy.card.dao.impl.CardOperDaoImpl;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;
import com.sanploy.card.pojo.CardOper;
import com.sanploy.card.service.CardOperService;

@Service("cardOperService")
public class CardOperServiceImpl implements CardOperService {

	@Resource(name="cardOperDao")
	private CardOperDaoImpl cardOperDao;

	@Override
	public Serializable save(CardOper model) {
		return cardOperDao.save(model);
	}

	@Override
	public void delete(CardOper model) {
		cardOperDao.delete(model);
	}

	@Override
	public void delete(String hql, Object[] param) {
		cardOperDao.delete(hql, param);
	}

	@Override
	public void deleteAll(List<CardOper> list) {
		cardOperDao.deleteAll(list);
	}

	@Override
	public void deleteAll(CardOper[] objectArray) {
		cardOperDao.deleteAll(objectArray);
	}

	@Override
	public void delete(Serializable id) {
		cardOperDao.delete(id);
	}

	@Override
	public void update(CardOper model) {
		cardOperDao.update(model);
	}

	@Override
	public void saveOrUpdate(CardOper model) {
		cardOperDao.saveOrUpdate(model);
	}

	@Override
	public void batchUpdate(List<CardOper> list) {
		cardOperDao.batchUpdate(list);
	}

	@Override
	public String getLimitString(String sql, int start, int size) {
		return cardOperDao.getLimitString(sql, start, size);
	}

	@Override
	public int execte(String hql, Object... paramlist) {
		return cardOperDao.execte(hql, paramlist);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getObject(String hql, Object[] param) {
		return cardOperDao.getObject(hql, param);
	}

	@Override
	public CardOper get(Serializable id) {
		return cardOperDao.get(id);
	}

	@Override
	public CardOper unique(String hql, Object[] param) {
		return (CardOper) cardOperDao.unique(hql, param);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List list() {
		return cardOperDao.list();
	}

	@Override
	public List<CardOper> list(int start, int size, String order) {
		return cardOperDao.list(start, size, order);
	}

	@Override
	public List<CardOper> list(String condition, Object[] param) {
		return cardOperDao.list(condition, param);
	}

	@Override
	public List<CardOper> list(String hql, Object[] param, int start, int size, String order) {
		return cardOperDao.list(hql, param, start, size, order);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page getPage(int currentPage, HqlHelper hqlHelper) {
		return cardOperDao.getPage(currentPage, hqlHelper);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page getPage(int currentPage, SqlHelper sqlHelper) {
		return cardOperDao.getPage(currentPage, sqlHelper);
	}

	@Override
	public int count() {
		return cardOperDao.count();
	}

	@Override
	public int count(String hql, Object[] param) {
		return cardOperDao.count(hql, param);
	}

	@Override
	public List<CardOper> criteriaList(Criteria criteria, int start, int size, String order) {
		return cardOperDao.criteriaList(criteria, start, size, order);
	}

	@Override
	public boolean isExists(Object propertyName, Serializable property) {
		return cardOperDao.isExists(propertyName, property);
	}
	
}
