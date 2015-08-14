
package com.sanploy.card.test;

import javax.sql.DataSource;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class DataSourceTest {

	private static Logger log = LoggerFactory.getLogger(DataSourceTest.class);
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
	public void testCreateDatabase() {
		// ClassPathResource ac = new ClassPathResource("applicationContext.xml");
		// XmlBeanFactory xbf = new XmlBeanFactory(ac);
		// BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		// XmlBeanDefinitionReader xdr = new XmlBeanDefinitionReader(registry);
		// 注意： &sessionFactory ，一定要包含 &
		// ，不加Spring返回的是Hibernate下的SessionFactoryImpl类
		// LocalSessionFactoryBean lsfb = (LocalSessionFactoryBean)
		// xbf.getBean("&sessionFactory");
		LocalSessionFactoryBean lsfb = (LocalSessionFactoryBean) applicationContext.getBean("&sessionFactory");
		Configuration cfg = lsfb.getConfiguration();
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
	}

}
