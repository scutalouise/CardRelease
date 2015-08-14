package com.sanploy.card.service;

import java.io.Serializable;

import javax.transaction.Transactional;

import com.sanploy.card.pojo.CardOper;
import com.sanploy.card.pojo.Customer;

@Transactional
public interface CardOperService extends IBaseService<CardOper> {
	/**
	 * @Description:用事务来控制新增和修改
	 * @param cardOper
	 * @param customer
	 * @return
	 * @since:2015年7月28日 上午9:38:59
	 */
	public Serializable save(CardOper cardOper, Customer customer);
	
}
