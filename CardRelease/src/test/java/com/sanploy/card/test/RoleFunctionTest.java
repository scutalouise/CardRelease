package com.sanploy.card.test;

import java.util.Collection;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sanploy.card.pojo.Function;
import com.sanploy.card.pojo.Role;
import com.sanploy.card.pojo.RoleFunction;
import com.sanploy.card.pojo.RoleFunctionPK;
import com.sanploy.card.service.FunctionService;
import com.sanploy.card.service.RoleFunctionService;
import com.sanploy.card.service.RoleService;

public class RoleFunctionTest {

	private static Logger log = LoggerFactory.getLogger(RoleFunctionTest.class);
	ApplicationContext applicationContext = null;
	DataSource dataSource = null;

	@Before
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		dataSource = (DataSource) applicationContext.getBean("dataSource");
		log.debug(dataSource.toString());
	}

	@Test
	public void testDataSource() {
		System.out.println(dataSource);
		log.error("print dataSource...");
	}

	@Test
	public void testSave() {
		RoleService roleService = (RoleService) applicationContext.getBean("roleService");
		FunctionService functionService = (FunctionService) applicationContext.getBean("functionService");
		RoleFunctionService roleFunctionService = (RoleFunctionService) applicationContext.getBean("roleFunctionService");
		Role role = new Role();
		Function function = new Function();
		RoleFunction rf = new RoleFunction();

		role.setSetTime(new Date());
		role.setOperateDate(new Date());
		role.setOperator("adfs");
		role.setRoleName("aaaa");
		role.setState("1");
		role.setValidTime(new Date());

		function.setCreateDate(new Date());
		function.setFunctionName("bbbbb");
		function.setOperateDate(new Date());
		function.setOperator("22222");
		function.setState("1");
		function.setUrl("http://www.baidu.com");

		rf.setFunction(function);
		rf.setRole(role);
		rf.setOperateDate(new Date());
		rf.setOperator("ccccc");

		roleService.save(role);
		functionService.save(function);
		roleFunctionService.save(rf);
	}
	
	
	@Test
	public void testBatchSave() {
		RoleService roleService = (RoleService) applicationContext.getBean("roleService");
		FunctionService functionService = (FunctionService) applicationContext.getBean("functionService");
		RoleFunctionService roleFunctionService = (RoleFunctionService) applicationContext.getBean("roleFunctionService");
		Role role = new Role();
		Function function = new Function();
		RoleFunction rf = new RoleFunction();

		role.setSetTime(new Date());
		role.setOperateDate(new Date());
		role.setOperator("adfs");
		role.setRoleName("aaaa");
		role.setState("1");
		role.setValidTime(new Date());

		function.setCreateDate(new Date());
		function.setFunctionName("bbbbb");
		function.setOperateDate(new Date());
		function.setOperator("22222");
		function.setState("1");
		function.setUrl("http://www.baidu.com");

		rf.setFunction(function);
		rf.setRole(role);
		rf.setOperateDate(new Date());
		rf.setOperator("ccccc");

		roleService.save(role);
		functionService.save(function);
		roleFunctionService.save(rf);
	}

	@Test
	public void testUpdate() {
		// RoleService roleService = (RoleService)
		// applicationContext.getBean("roleService");
		// Role role = roleService.get(1L);
		// role.setRemark("sdfsdf");
		// roleService.saveOrUpdate(role);

		RoleFunctionService roleFunctionService = (RoleFunctionService) applicationContext.getBean("roleFunctionService");
		RoleFunctionPK pk = new RoleFunctionPK();
		Function function = new Function();
		function.setFunctionId(13);
		pk.setFunction(function);
		Role r = new Role();
		r.setRoleId(13);
		pk.setRole(r);
		RoleFunction rf = roleFunctionService.get(pk);
		rf.getFunction().setUrl("www.hainu.edu.cn");
		roleFunctionService.update(rf);
	}
	
	@Test
	public void testQuery(){
		RoleFunctionService roleFunctionService = (RoleFunctionService) applicationContext.getBean("roleFunctionService");
		String hql = "from RoleFunction where role.roleId = ?";
		Long[] param = {1L};
//		Collection<RoleFunction> rfs = roleFunctionService.list(hql, param, 0, 0, null);
		Collection<RoleFunction> rfs = roleFunctionService.getObject(hql, param);
//		Collection<RoleFunction> rfs = roleFunctionService.list("roleFunctionPk.role.roleId", param);
		System.out.println(rfs.size());
	}
	
}
