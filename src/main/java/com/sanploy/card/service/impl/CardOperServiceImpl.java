package com.sanploy.card.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sanploy.card.dao.impl.CardOperDaoImpl;
import com.sanploy.card.dao.impl.CustomerDaoImpl;
import com.sanploy.card.dao.impl.TradePointDaoImpl;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;
import com.sanploy.card.pojo.CardOper;
import com.sanploy.card.pojo.Customer;
import com.sanploy.card.pojo.TradePoint;
import com.sanploy.card.service.CardOperService;
import com.sanploy.card.utils.DateUtils;

@Service("cardOperService")
public class CardOperServiceImpl implements CardOperService {

	@Resource(name = "cardOperDao")
	private CardOperDaoImpl cardOperDao;

	@Resource(name = "customerDao")
	private CustomerDaoImpl customerDao;

	@Resource(name = "tradePointDao")
	private TradePointDaoImpl tradePointDao;

	@Override
	public Serializable save(CardOper model) {
		return cardOperDao.save(model);
	}

	@Override
	public Serializable save(CardOper model, Customer customer) {
		// 根据model的newCardNo判断是否为补卡；
		if (null != model.getNewCardNo()) {
			/**
			 * 主要插入交易,为新发卡的交易 查询出当前操作记录表中，对应的原补卡的卡号对应的操作记录，最后一条记录；不论充点还是消费
			 */
			String hql = "from TradePoint where cardNo=? order by tradeDate DESC";
			TradePoint tradePointFromDB = (TradePoint) tradePointDao.unique(hql, new String[] { model.getOldCardNo() });
			TradePoint tradePoint = new TradePoint();
			BeanUtils.copyProperties(tradePointFromDB, tradePoint);
			tradePoint.setCardNo(model.getNewCardNo());
			tradePoint.setTradeDate(new Date());
			tradePoint.setOperateDate(new Date());
			tradePoint.setOperator(model.getOperator());

			String hqlForId = "select MAX(tradePointNo) from TradePoint";
			String id = "";
			List<Object> list = tradePointDao.getObject(hqlForId, new String[] {});
			String maxId = (String) list.get(0);
			String date = DateUtils.formatFromDate("yyyyMMdd", new Date());
			if (null != maxId) {
				int sufix = Integer.parseInt(maxId.substring(8));
				sufix = sufix + 1;
				String temp = String.valueOf(sufix);
				if (null != temp) {
					if (temp.length() > 4) {
						temp.substring(temp.length() - 4, temp.length());
					} else {
						for (int i = 0; i < 4 - temp.length(); i++) {
							temp = "0" + temp;
						}
					}
				}
				id = date + temp;
			} else {// 数据库中不存在id
				id = date + "0001";
			}
			tradePoint.setTradePointNo(id);// 设置新增交易的交易编号
			//保存新交易(补卡的新交易)
			tradePointDao.save(tradePoint);
		}
		customerDao.update(customer);
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
