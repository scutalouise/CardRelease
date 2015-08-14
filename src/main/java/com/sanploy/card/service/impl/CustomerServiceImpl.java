package com.sanploy.card.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import com.sanploy.card.dao.impl.CustomerDaoImpl;
import com.sanploy.card.dao.impl.TradePointDaoImpl;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;
import com.sanploy.card.pojo.Customer;
import com.sanploy.card.pojo.TradePoint;
import com.sanploy.card.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource(name="customerDao")
	private CustomerDaoImpl customerDao;
	
	@Resource
	private TradePointDaoImpl tradePointDao;
	
	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#save(java.lang.Object)
	 */
	@Override
	public Serializable save(Customer model) {
		//保存一个客户的时候，需要保存一条客户的充值记录
		return customerDao.save(model);
	}
	
	@Override
	public Serializable save(Customer customer, TradePoint tradePoint) {
		customer.setOperateDate(new Date());
		String id = (String) customerDao.save(customer);
		tradePoint.setCardNo(customer.getCardNo());
		tradePoint.setCustomer(customer);
		tradePoint.setOperateDate(customer.getOperateDate());
		tradePoint.setOperator(customer.getOperator());
		tradePoint.setPtAfter(customer.getOriginalPt());
		tradePoint.setPtBefore("0");
		tradePoint.setPtTrade(customer.getOriginalPt());
		tradePoint.setTradeDate(new Date());
		tradePoint.setTradeType("1");//交易类型（1-充点，2-扣点）
		tradePointDao.save(tradePoint);
		
		return id;
	}
	
	

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Customer model) {
		customerDao.delete(model);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#delete(java.lang.String, java.lang.Object[])
	 */
	@Override
	public void delete(String hql, Object[] param) {
		customerDao.delete(hql, param);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.util.List)
	 */
	@Override
	public void deleteAll(List<Customer> list) {
		customerDao.deleteAll(list);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#deleteAll(java.lang.Object[])
	 */
	@Override
	public void deleteAll(Customer[] objectArray) {
		customerDao.deleteAll(objectArray);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Serializable id) {
		customerDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#update(java.lang.Object)
	 */
	@Override
	public void update(Customer model) {
		customerDao.update(model);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Customer model) {
		model.setOperateDate(new Date());
		customerDao.saveOrUpdate(model);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#batchUpdate(java.util.List)
	 */
	@Override
	public void batchUpdate(List<Customer> list) {
		customerDao.batchUpdate(list);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#getLimitString(java.lang.String, int, int)
	 */
	@Override
	public String getLimitString(String sql, int start, int size) {
		return customerDao.getLimitString(sql, start, size);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#execte(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int execte(String hql, Object... paramlist) {
		return customerDao.execte(hql, paramlist);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#get(java.io.Serializable)
	 */
	@Override
	public Customer get(Serializable id) {
		return customerDao.get(id);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#unique(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Customer unique(String hql, Object[] param) {
		return (Customer) customerDao.unique(hql, param);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#list()
	 */
	@Override
	public List<Customer> list() {
		return customerDao.list();
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#list(int, int, java.lang.String)
	 */
	@Override
	public List<Customer> list(int start, int size, String order) {
		return customerDao.list(start, size, order);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<Customer> list(String condition, Object[] param) {
		return customerDao.list(condition, param);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#list(java.lang.String, java.lang.Object[], int, int, java.lang.String)
	 */
	@Override
	public List<Customer> list(String hql, Object[] param, int start, int size, String order) {
		return customerDao.list(hql, param, start, size, order);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#getPage(int, com.sanploy.card.dao.utils.HqlHelper)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getPage(int currentPage, HqlHelper hqlHelper) {
		return customerDao.getPage(currentPage, hqlHelper);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#getPage(int, com.sanploy.card.dao.utils.SqlHelper)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getPage(int currentPage, SqlHelper sqlHelper) {
		return customerDao.getPage(currentPage, sqlHelper);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#count()
	 */
	@Override
	public int count() {
		return customerDao.count();
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#count(java.lang.String, java.lang.Object[])
	 */
	@Override
	public int count(String hql, Object[] param) {
		return customerDao.count(hql, param);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#criteriaList(org.hibernate.Criteria, int, int, java.lang.String)
	 */
	@Override
	public List<Customer> criteriaList(Criteria criteria, int start, int size, String order) {
		return customerDao.criteriaList(criteria, start, size, order);
	}

	/* (non-Javadoc)
	 * @see com.sanploy.card.service.IBaseService#isExists(java.lang.Object, java.io.Serializable)
	 */
	@Override
	public boolean isExists(Object propertyName, Serializable property) {
		return customerDao.isExists(propertyName, property);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getObject(String hql, Object[] param) {
		return customerDao.getObject(hql, param);
	}

	@Override
	public boolean isInValid(String cardNo) {
		return customerDao.isInValid(cardNo);
	}
}
