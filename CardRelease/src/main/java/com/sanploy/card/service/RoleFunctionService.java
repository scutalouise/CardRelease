package com.sanploy.card.service;

import javax.transaction.Transactional;

import com.sanploy.card.pojo.RoleFunction;

@Transactional
public interface RoleFunctionService extends IBaseService<RoleFunction> {

	public void save(Long roleId, Long[] functionIds,String operator);

}
