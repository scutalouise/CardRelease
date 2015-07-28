package com.sanploy.card.dao.utils;

import java.util.ArrayList;
import java.util.List;

import com.sanploy.card.service.IBaseService;

/**
 * 用于辅助拼接生成HQL的工具类
 * 
 * @author tyg
 */
public class HqlHelper {

	private String fromClause; // From子句，必须
	private String whereClause = ""; // Where子句，可选
	private String orderByClause = ""; // OrderBy子句，可选
	private String hqlClause = ""; // 封装fromClause +
									// whereClause语句，以便在HqlHelper(String
									// hql,String orderByClause)中扩展
	private String hqlClauseCount = "";
	private List<Object> parameters = new ArrayList<Object>(); // 参数列表

	/**
	 * 生成From子句，默认的别名为'o'
	 * 
	 * @param clazz
	 */
	@SuppressWarnings("rawtypes")
	public HqlHelper(Class clazz) {
		this.fromClause = "FROM " + clazz.getSimpleName() + " o";
	}

	/**
	 * 直接传递hql语句，当在写hql语句时，需要加载多个关联关系的对象时，直接传hql语句，以避免N+1的性能问题；
	 * 当没有orderByClause时，传""空值；
	 * 
	 * @param hql
	 * <br>
	 * @param hqlCount
	 * <br>
	 * @param orderByClause
	 */
	public HqlHelper(String hql, String hqlCount, String orderByClause) {
		this.hqlClauseCount = hqlCount;
		this.hqlClause = hql;
		this.orderByClause = " " + orderByClause;
	}

	/**
	 * 拼接Where子句
	 * 
	 * @param condition
	 * @param params
	 */
	public HqlHelper addCondition(String condition, Object... params) {
		// 拼接
		if (whereClause.length() == 0) {
			whereClause = " WHERE " + condition + " ";
		} else {
			whereClause += " AND " + condition + " ";
		}

		// 保存参数
		if (params != null && params.length > 0) {
			for (Object obj : params) {
				parameters.add(obj);
			}
		}
		
		return this;
	}

	/**
	 * 拼接OrderBy子句
	 * 
	 * @param propertyName
	 *            属性名
	 * @param isAsc
	 *            true表示升序，false表示降序
	 */
	public HqlHelper addOrder(String propertyName, boolean isAsc) {
		if (orderByClause.length() == 0) {
			orderByClause = " ORDER BY " + propertyName + (isAsc ? " ASC" : " DESC");
		} else {
			orderByClause += ", " + propertyName + (isAsc ? " ASC" : " DESC");
		}
		return this;
	}

	/**
	 * 获取生成的查询数据列表的HQL语句
	 * 两种格式的HqlHelper,最后拼装成sql语句不一样；需要以hql的形式
	 * @return
	 */
	public String getQueryListHql() {
		
		if (fromClause != null && !"".equals(fromClause)) {
			hqlClause = fromClause + whereClause;
		} else {
			hqlClause = hqlClause + whereClause + orderByClause;
		}
		return hqlClause;
	}

	/**
	 * 获取生成的查询总记录数的HQL语句（没有OrderBy子句）
	 * 
	 * @return
	 */
	public String getQueryCountHql() {
		/*
		 * 两种格式的HqlHelper,最后拼装成sql语句不一样；需要以hql的形式
		 */
		if (fromClause != null && !"".equals(fromClause)) {
			return "SELECT COUNT(*) " + fromClause + whereClause;
		} else {
			hqlClauseCount = hqlClauseCount + whereClause;
		}
		return hqlClauseCount;
	}

	/**
	 * 获取参数列表，与HQL过滤条件中的'?'一一对应
	 * 
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}

	/**
	 * 查询并准备分页信息（直接返回）
	 * 
	 * @param currentPage
	 * @param service
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Page buildPage(int currentPage, IBaseService service) {
		Page page = service.getPage(currentPage, this);
		return page;
	}

}
