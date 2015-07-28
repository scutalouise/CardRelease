package com.sanploy.card.dao.impl;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sanploy.card.pojo.Function;
import com.sanploy.card.pojo.Role;
import com.sanploy.card.pojo.RoleFunction;

@Repository("roleFunctionDao")
public class RoleFunctionDaoImpl extends BaseDaoImpl<RoleFunction> {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Long roleId, Long[] functionIds, String operator) {
		Role role = new Role();
		role.setRoleId(roleId);

		for (Long functionId : functionIds) {
			Function function = new Function();
			function.setFunctionId(functionId);

			RoleFunction rf = new RoleFunction();
			rf.setFunction(function);
			rf.setRole(role);
			rf.setOperateDate(new Date());
			rf.setOperator(operator);// 从session中获取

			sessionFactory.getCurrentSession().save(rf);
		}

	}

}
