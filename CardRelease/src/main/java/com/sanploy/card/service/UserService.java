package com.sanploy.card.service;

import javax.transaction.Transactional;

import com.sanploy.card.pojo.User;

@Transactional
public interface UserService extends IBaseService<User> {

}
