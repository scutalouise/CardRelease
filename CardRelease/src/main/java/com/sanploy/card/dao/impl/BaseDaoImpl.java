package com.sanploy.card.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sanploy.card.dao.IBaseDao;
import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;

public class BaseDaoImpl<T> implements IBaseDao<T> {

	private static Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> entityClass;

	/**
	 * 无参构造器：根据泛型类型，判断传入的具体入参类型entityClass，是接下来很多方法调用的基础；
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.entityClass = null;
		Class<?> c = getClass();
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
			this.entityClass = (Class<T>) parameterizedType[0];
		}
		// System.out.println("当前实际对象为：" + entityClass.getName());
	}

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @Description:根据主键，返回实体
	 * @see com.sanploy.card.dao.IBaseDao#get(java.io.Serializable)
	 * @param id
	 * @return 实体或空（如果没有查到）
	 * @since:2015年7月10日 上午10:28:20
	 */
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		if (null == id) {
			return null;
		}
		T t = null;
		try {
			t = (T) getSession().get(entityClass, id);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("通过主键查询实体失败", e);
			}
		}
		return t;
	}

	/**
	 * @Description:保存实体对象，返回主键
	 * @see com.sanploy.card.dao.IBaseDao#save(java.lang.Object)
	 * @param model
	 * @return 序列化的已经保存实体id
	 * @since:2015年7月10日 上午10:27:31
	 */
	public Serializable save(T model) {
		return getSession().save(model);
	}

	/**
	 * @Description:更新实体对象，不返回值
	 * @see com.sanploy.card.dao.IBaseDao#update(java.lang.Object)
	 * @param model
	 * @since:2015年7月10日 上午10:27:18
	 */
	public void update(T model) {
		getSession().update(model);
	}

	/**
	 * @Description:删除指定对象，不返回值
	 * @see com.sanploy.card.dao.IBaseDao#delete(java.lang.Object)
	 * @param model
	 * @since:2015年7月10日 上午10:26:53
	 */
	public void delete(T model) {
		getSession().delete(model);
	}

	/**
	 * @Description:删除对象列表，不返回值;注意批量删除的性能，内存占用！
	 * @see com.sanploy.card.dao.IBaseDao#deleteAll(java.util.List)
	 * @param list
	 * @since:2015年7月10日 上午10:26:42
	 */
	public void deleteAll(List<T> list) {
		if (null != list && list.size() > 0) {
			for (Iterator<T> iter = list.iterator(); iter.hasNext();) {
				delete(iter.next());
			}
		}
	}

	/**
	 * @Description:删除对象列表，不返回值;注意批量删除的性能，内存占用！
	 * @see com.sanploy.card.dao.IBaseDao#deleteAll(java.lang.Object[])
	 * @param objectArray
	 * @since:2015年7月10日 上午10:26:31
	 */
	public void deleteAll(T[] objectArray) {
		if (null != objectArray) {
			for (int i = 0; i < objectArray.length; i++) {
				delete(objectArray[i]);
			}
		}
	}

	/**
	 * @Description:根据主键删除
	 * @see com.sanploy.card.dao.IBaseDao#delete(java.io.Serializable)
	 * @param id
	 * @since:2015年7月10日 上午10:19:35
	 */
	public void delete(Serializable id) {
		if (null == id) {
			return;
		}
		getSession().delete(this.get(id));
	}

	/**
	 * @Description:保存或更新,底层直接调用session.saveOrUpdate
	 * @see com.sanploy.card.dao.IBaseDao#saveOrUpdate(java.lang.Object)
	 * @param model
	 * @since:2015年7月10日 上午10:19:53
	 */
	public void saveOrUpdate(T model) {
		getSession().saveOrUpdate(model);
	}

	/**
	 * @Description:根据查询条件返回唯一一条记录 如果查询出多条，返回第一条
	 * @see com.sanploy.card.dao.IBaseDao#unique(java.lang.String,
	 *      java.lang.Object[])
	 * @param hql
	 * @param param
	 * @return 如果查不到东西返回null
	 * @since:2015年7月10日 上午10:20:29
	 */
	public Object unique(final String hql, final Object[] param) {
		Query query = getSession().createQuery(hql);
		setParameters(query, param);
		return query.setMaxResults(1).uniqueResult();
	}

	/**
	 * @Description:分页查询方法
	 * @see com.sanploy.card.dao.IBaseDao#list(int, int, java.lang.String)
	 * @param start
	 *            分页起始数，第1页应为0
	 * @param size
	 *            每个分页大小
	 * @param order
	 *            排序语句,本方法会自动加上" order by "关键字
	 * @return 封装有所查询实体类的列表,可能返回null
	 * @since:2015年7月10日 上午10:20:48
	 */
	public List<T> list(int start, int size, String order) {
		String sql = " from " + entityClass.getSimpleName();
		return list(sql, null, start, size, order);
	}

	/**
	 * @Description:分页查询
	 * @see com.sanploy.card.dao.IBaseDao#list(java.lang.String,
	 *      java.lang.Object[])
	 * @param condition
	 * @param param
	 * @return 封装有所查询实体类的列表,可能返回null
	 * @since:2015年7月10日 上午10:29:47
	 */
	public List<T> list(String condition, Object[] param) {
		String sql = " from " + entityClass.getSimpleName();
		if (null != condition && condition.length() > 0) {
			sql += " where " + condition;
		}
		return list(sql, param, 0, 0, null);
	}

	/**
	 * @Description: 分页查询，直接返回page对象
	 * @see com.sanploy.card.dao.IBaseDao#getPage(int,
	 *      com.sanploy.card.dao.utils.HqlHelper)
	 * @param currentPage
	 * @param hqlHelper
	 * @return page
	 * @since:2015年7月8日 下午5:04:28
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getPage(int currentPage, HqlHelper hqlHelper) {
		Page page = new Page();
		page.setCurrentPage(currentPage);
		// 查询本页的数据列表
		Query queryList = getSession().createQuery(hqlHelper.getQueryListHql());
		List<Object> parameters = hqlHelper.getParameters();
		if (parameters != null && parameters.size() > 0) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				queryList.setParameter(i, parameters.get(i));
			}
		}
		queryList.setFirstResult((currentPage - 1) * page.getPageSize()); //应该是从0条记录开始，查询结果
		queryList.setMaxResults(page.getPageSize());//参考上一条注释
		page.setRecordList(queryList.list());

		// 查询本页的数量
		Query queryCount = getSession().createQuery(hqlHelper.getQueryCountHql());
		if (parameters != null && parameters.size() > 0) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				queryCount.setParameter(i, parameters.get(i));
			}
		}
		Long l = (Long) queryCount.uniqueResult();
		page.setRecordCount(l.intValue());// 执行查询
		return page;
	}

	/**
	 * @Description:分页查询，直接返回page对象
	 * @see com.sanploy.card.dao.IBaseDao#getPage(int,
	 *      com.sanploy.card.dao.utils.SqlHelper)
	 * @param currentPage
	 * @param sqlHelper
	 * @return page
	 * @since:2015年7月8日 下午5:04:55
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page getPage(int currentPage,SqlHelper sqlHelper) {
		Page page = new Page();
		page.setCurrentPage(currentPage);
		// 查询本页的数据列表
		Query queryList = getSession().createQuery(sqlHelper.getQueryListSql());
		List<Object> parameters = sqlHelper.getParameters();
		if (parameters != null && parameters.size() > 0) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				queryList.setParameter(i, parameters.get(i));
			}
		}
		queryList.setFirstResult((currentPage - 1) * page.getPageSize());
		queryList.setMaxResults(page.getPageSize());
		page.setRecordList(queryList.list());

		// 查询本页的数量
		Query queryCount = getSession().createQuery(sqlHelper.getQueryCountSql());
		if (parameters != null && parameters.size() > 0) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				queryCount.setParameter(i, parameters.get(i));
			}
		}

		Long l = (Long) queryCount.uniqueResult();
		page.setRecordCount(l.intValue());// 执行查询

		return page;
	}

	/**
	 * @Description:返回个数,不包含条件，查询出所有的数量
	 * @see com.sanploy.card.dao.IBaseDao#count()
	 * @return
	 * @since:2015年7月10日 上午10:22:09
	 */
	public int count() {
		String sql = " select count(*) from " + entityClass.getSimpleName();
		return count(sql, null);
	}

	/**
	 * @Description:返回个数
	 * @see com.sanploy.card.dao.IBaseDao#count(java.lang.String,
	 *      java.lang.Object[])
	 * @param hql
	 *            符合HQL语法的count语句
	 * @param param
	 * @return 查询的结果,如果出错,返回0
	 * @since:2015年7月10日 上午10:22:35
	 */
	public int count(String hql, Object[] param) {
		Query query = getSession().createQuery(hql);
		setParameters(query, param);
		Object o = query.setMaxResults(0).uniqueResult();
		int count = 0;
		try {
			count = Integer.parseInt(o.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return count;
	}

	/**
	 * @Description:分页查询方法
	 * @see com.sanploy.card.dao.IBaseDao#list(java.lang.String,
	 *      java.lang.Object[], int, int, java.lang.String)
	 * @param hql
	 *            要求为hql语句
	 * @param param
	 *            参数数组
	 * @param start
	 *            分页起始数，第1页应为0
	 * @param size
	 *            每个分页大小
	 * @param order
	 *            排序语句,本方法会自动加上" order by "关键字
	 * @return 封装有所查询实体类的列表,可能返回null
	 * @since:2015年7月10日 上午10:30:20
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(String hql, Object[] param, int start, int size, String order) {
		if (null != order && order.length() > 0) {
			hql += " order by " + order;
		}
		Query query = getSession().createQuery(hql);
		setParameters(query, param);
		if (start >= 0) { // 开始页数不小于0才进行分页
			if (size > 0) { // 每页限制数量大于0才进行分页,不然无意义
				query.setFirstResult(start * size);
				query.setMaxResults(size);
			} else { // 每页限制数量不大于0时,分页无意义
				query.setFirstResult(0);
			}
		}
		return (List<T>) query.list();
	}

	/**
	 * @Description:
	 * @see com.sanploy.card.dao.IBaseDao#criteriaList(org.hibernate.Criteria,
	 *      int, int, java.lang.String)
	 * @param criteria
	 * @param start
	 * @param size
	 * @param order
	 * @return
	 * @since:2015年7月10日 上午10:16:45
	 */
	@SuppressWarnings({ "unchecked" })
	public List<T> criteriaList(Criteria criteria, int start, int size, String order) {
		if (order != null && order.length() > 0) {
			String[] orders = order.split(" ");
			if ("desc".equals(orders[1])) {
				criteria.addOrder(Order.desc(orders[0]));
			} else {
				criteria.addOrder(Order.asc(orders[0]));
			}
		}
		if (start >= 0) { // 开始页数不小于0才进行分页
			if (size > 0) { // 每页限制数量大于0才进行分页,不然无意义
				criteria.setFirstResult(start * size);
				criteria.setMaxResults(size);
			} else { // 每页限制数量不大于0时,分页无意义
				criteria.setFirstResult(0);
			}
		}
		return criteria.list();
	}

	/**
	 * @Description:把普通sql语句,处理成分页语句</br>
	 * @see com.sanploy.card.dao.IBaseDao#getLimitString(java.lang.String, int,
	 *      int)
	 * @param sql
	 *            纯sql语句
	 * @param start
	 *            起始页码
	 * @param size
	 *            每页个数
	 * @return 返回的是拼装好的mysql的sql语句
	 * @since:2015年7月10日 上午10:25:14
	 */
	public String getLimitString(String sql, int start, int size) {
		// 只有在页数不为负且每页为正的时候,才进行分页
		if (start >= 0 && size > 0) {
			sql = sql + " limit " + start * size + ", " + size;
		}
		return sql;
	}

	/**
	 * @Description:删除操作
	 * @see com.sanploy.card.dao.IBaseDao#delete(java.lang.String,
	 *      java.lang.Object[])
	 * @param hql
	 * @param param
	 * @since:2015年7月10日 上午10:24:41
	 */
	public void delete(final String hql, Object[] param) {
		Query query = getSession().createQuery(hql);
		setParameters(query, param);
		query.executeUpdate();
	}

	/**
	 * @Description:使用Criteria，查出所有相关实体的信息
	 * @see com.sanploy.card.dao.IBaseDao#list()
	 * @return
	 * @since:2015年7月10日 上午10:24:09
	 */
	@SuppressWarnings("unchecked")
	public List<T> list() {
		Criteria criteria = getSession().createCriteria(entityClass);
		return criteria.list();
	}

	public int execte(final String hql, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		setParameters(query, paramlist);
		return query.executeUpdate();
	}

	/**
	 * @Description:批量更新多个实体。注意内容消耗，性能;缓存问题未考虑
	 * @see com.sanploy.card.dao.IBaseDao#batchUpdate(java.util.List)
	 * @param list
	 * @since:2015年7月10日 上午10:31:11
	 */
	public void batchUpdate(List<T> list) {
		if (null != list && list.size() > 0) {
			for (Iterator<T> iter = list.iterator(); iter.hasNext();) {
				update(iter.next());
			}
		}
	}

	/**
	 * @Description:对查询语句hql或sql，以及入参进行设置，一一对应；
	 * @param query
	 * @param paramlist
	 * @since:2015年7月10日 上午10:23:25
	 */
	protected void setParameters(Query query, Object[] paramlist) {
		if (paramlist != null) {
			for (int i = 0; i < paramlist.length; i++) {
				if (paramlist[i] instanceof Date) {
					// 难道这是bug 使用setParameter不行？？
					query.setTimestamp(i, (Date) paramlist[i]);
				} else {
					query.setParameter(i, paramlist[i]);
				}
			}
		}
	}

	/**
	 * @Description:根据实体的属性和属性值，判断，是否存在对应的实体；
	 * @see com.sanploy.card.dao.IBaseDao#isExists(java.lang.Object,
	 *      java.io.Serializable)
	 * @param propertyName
	 * @param property
	 * @return boolean
	 * @since:2015年7月10日 上午10:17:03
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean isExists(Object propertyName, Serializable property) {
		Query query = getSession().createQuery("from " + this.entityClass.getName() + " where " + propertyName + "=:propertyName");
		query.setParameter("propertyName", property);
		T t = (T) query.uniqueResult();
		return t == null ? false : true;
	}

	@Override
	@SuppressWarnings({ "unchecked"})
	public List<Object> getObject(String hql, Object[] param) {
		Query query = getSession().createQuery(hql);
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				if (param[i] instanceof Date) {
					// 难道这是bug 使用setParameter不行？？
					query.setTimestamp(i, (Date) param[i]);
				} else {
					query.setParameter(i, param[i]);
				}
			}
		}
		return query.list();
	}
}
