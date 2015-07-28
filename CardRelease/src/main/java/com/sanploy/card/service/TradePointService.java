package com.sanploy.card.service;

import javax.transaction.Transactional;

import com.sanploy.card.pojo.TradePoint;

@Transactional
public interface TradePointService extends IBaseService<TradePoint> {
	
//	public Serializable save(TradePoint tradePoint, Customer customer);
	
}
