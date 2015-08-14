package com.sanploy.card.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import com.sanploy.card.pojo.Customer;
import com.sanploy.card.pojo.TradePoint;

@Transactional
public interface CustomerService extends IBaseService<Customer> {
	
	/**
	 * @Description:返回保存customer的id
	 * @param customer
	 * @param tradePoint
	 * @return
	 * @since:2015年7月20日 下午4:55:03
	 */
	public Serializable save(Customer customer, TradePoint tradePoint);
	
	
	public boolean isInValid(String cardNo);
	
}
