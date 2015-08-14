package com.sanploy.card.service;

import javax.transaction.Transactional;

import com.sanploy.card.pojo.BankCardType;

@Transactional
public interface BankCardTypeService extends IBaseService<BankCardType> {

}
