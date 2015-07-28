package com.sanploy.card.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

import com.sanploy.card.dao.utils.HqlHelper;
import com.sanploy.card.dao.utils.Page;
import com.sanploy.card.dao.utils.SqlHelper;

public interface IBaseDao<T> {

	/**
	 * 保存实体对象，返回主键
	 * 
	 * @param model
	 * @return
	 */
	public abstract Serializable save(T model);

	/**
	 * 删除指定对象，不返回值
	 * 
	 * @param model
	 */
	public abstract void delete(T model);

	/**
	 * 删除对象列表，不返回值
	 * 
	 * @param list
	 */
	public abstract void deleteAll(List<T> list);

	/**
	 * 删除对象列表，不返回值
	 * 
	 * @param objectArray
	 */
	public abstract void deleteAll(T[] objectArray);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 */
	public abstract void delete(Serializable id);

	/**
	 * 删除操作
	 * 
	 * @param hql
	 *            HQL语句
	 * @param param
	 */
	public abstract void delete(String hql, Object[] param);

	/**
	 * 更新实体对象，不返回值
	 * 
	 * @param model
	 */
	public abstract void update(T model);

	/**
	 * 保存或更新
	 * 
	 * @param model
	 *            实体类
	 */
	public abstract void saveOrUpdate(T model);

	/**
	 * 根据主键，返回实体
	 * 
	 * @param id
	 *            主键
	 * @return 实体或空（如果没有查到）
	 */
	public abstract T get(Serializable id);

	/**
	 * 根据查询条件返回唯一一条记录 如果查询出多条，返回第一条
	 * 
	 * @param hql
	 * @param param
	 * @return 如果查不到东西返回null
	 */
	public abstract Object unique(String hql, Object[] param);

	/**
	 * 把普通sql语句,处理成分页语句</br>
	 * 
	 * @param sql
	 *            纯sql语句
	 * @param start
	 *            起始页码
	 * @param size
	 *            每页个数
	 * @return
	 */
	public abstract String getLimitString(String sql, int start, int size);

	/**
	 * @Description:底层调用query.executeUpdate();因为为改、删、增？的操作；
	 * @param hql
	 * @param paramlist
	 * @return
	 * @since:2015年7月8日 下午2:39:44
	 */
	public abstract int execte(String hql, Object... paramlist);

	/**
	 * 批量更新多个实体。
	 * 
	 * @param list
	 */
	public abstract void batchUpdate(List<T> list);

	/**
	 * 查出所有相关实体的信息
	 * 
	 * @return
	 */
	public abstract List<T> list();

	/**
	 * 分页查询方法
	 * 
	 * @param start
	 *            分页起始数，第1页应为0
	 * @param size
	 *            每个分页大小
	 * @param order
	 *            排序语句,本方法会自动加上" order by "关键字
	 * @return 封装有所查询实体类的列表,可能返回null
	 */
	public abstract List<T> list(int start, int size, String order);

	/**
	 * 分页查询
	 * 
	 * @param condition
	 *            查询条件
	 * @param param
	 *            参数
	 * @return 封装有所查询实体类的列表,可能返回null
	 */
	public abstract List<T> list(String condition, Object[] param);

	/**
	 * 分页查询方法
	 * 
	 * @param hql
	 *            要求为hql语句
	 * @param param
	 *            参数
	 * @param start
	 *            分页起始数，第1页应为0
	 * @param size
	 *            每个分页大小
	 * @param order
	 *            排序语句,本方法会自动加上" order by "关键字
	 * @return 封装有所查询实体类的列表,可能返回null
	 */
	public abstract List<T> list(String hql, Object[] param, int start, int size, String order);

	@SuppressWarnings("rawtypes")
	public abstract Page getPage(int currentPage, HqlHelper hqlHelper);

	@SuppressWarnings("rawtypes")
	public abstract Page getPage(int currentPage, SqlHelper sqlHelper);

	/**
	 * 返回个数
	 * 
	 * @return
	 */
	public abstract int count();

	/**
	 * 返回个数
	 * 
	 * @param hql
	 *            符合HQL语法的count语句
	 * @param param
	 *            参数
	 * @return 查询的结果,如果出错,返回0
	 */
	public abstract int count(String hql, Object[] param);

	/**
	 * 分页查询方法
	 * 
	 * @param criteria
	 *            要求为criteria语句
	 * @param param
	 *            参数
	 * @param start
	 *            分页起始数，第1页应为0
	 * @param size
	 *            每个分页大小
	 * @param order
	 *            排序语句,本方法会自动加上" order by "关键字
	 * @return 封装有所查询实体类的列表,可能返回null
	 */
	public abstract List<T> criteriaList(Criteria criteria, int start, int size, String order);

	/**
	 * @Description:根据实体的属性和属性值判断是否存在
	 * @param propertyName
	 * @param property
	 * @return
	 * @since:2015年7月8日 下午5:22:52
	 */
	public abstract boolean isExists(Object propertyName, Serializable property);

	/**
	 * @Description:根据hql语句返回列数组
	 * @param hql
	 * @param param
	 * @return
	 * @since:2015年7月15日 下午5:04:47
	 */
	public abstract List<Object> getObject(String hql, Object[] param);

}