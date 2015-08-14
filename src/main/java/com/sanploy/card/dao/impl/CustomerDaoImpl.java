package com.sanploy.card.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sanploy.card.pojo.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> {

	@Resource
	private SessionFactory sessionFactory;

	public boolean isInValid(String cardNo) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Customer where TO_DAYS(NOW()) - TO_DAYS(invalid) > 0 and cardNo = ? ";
		Query query = session.createQuery(hql);
		query.setString(0, cardNo);
		Customer customer = (Customer) query.uniqueResult();
		return null == customer ? false : true;
	}

}
