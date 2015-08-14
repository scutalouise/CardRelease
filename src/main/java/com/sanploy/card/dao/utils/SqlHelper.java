package com.sanploy.card.dao.utils;

import java.util.ArrayList;
import java.util.List;

import com.sanploy.card.service.IBaseService;

/**
 * 用于辅助拼接生成HQL的工具类
 * @author tyg
 */
public class SqlHelper {

	private String whereClause = ""; 	// Where子句，可选
	private String orderByClause = ""; 	// OrderBy子句，可选
	private String sqlClause = "";		//封装selectClause + whereClause语句，以便在SqlHelper(String sql,String orderByClause)中扩展
	private String sqlClauseCount = "";
	private List<Object> parameters = new ArrayList<Object>(); // 参数列表
	
	/**
	 * 直接传递sql语句，当在写sql语句时，需要加载多个关联关系的对象时，直接传sql语句
	 * 当没有orderByClause时，传""空值；
	 * @param sql<br>
	 * @param sqlCount
	 * @param orderByClause
	 */
	public SqlHelper(String sql ,String sqlCount, String orderByClause){
		this.sqlClause = sql;
		this.sqlClauseCount = sqlCount;
		this.orderByClause = "  " + orderByClause;
	}

	/**
	 * 拼接Where子句
	 * @param condition
	 * @param params
	 */
	public SqlHelper addCondition(String condition, Object... params) {
		// 拼接
		if (whereClause.length() == 0) {
			whereClause = " WHERE " + condition;
		} else {
			whereClause += " AND " + condition;
		}

		// 保存参数
		if (params != null && params.length > 0 && !"".equals(params[0])) {
			for (Object obj : params) {
				parameters.add(obj);
			}
		}

		return this;
	}

	/**
	 * 拼接OrderBy子句
	 * @param propertyName
	 *            属性名
	 * @param isAsc
	 *            true表示升序，false表示降序
	 */
	public SqlHelper addOrder(String propertyName, boolean isAsc) {
		if (orderByClause.length() == 0) {
			orderByClause = " ORDER BY " + propertyName + (isAsc ? " ASC" : " DESC");
		} else {
			orderByClause += ", " + propertyName + (isAsc ? " ASC" : " DESC");
		}
		return this;
	}

	/**
	 * 获取生成的查询数据列表的SQL语句
	 * @return
	 */
	public String getQueryListSql() {
		return  sqlClause + whereClause + orderByClause;
	}

	/**
	 * 获取生成的查询总记录数的HQL语句（没有OrderBy子句）
	 * @return
	 */
	public String getQueryCountSql() {
		return sqlClauseCount + whereClause;
	}

	/**
	 * 获取参数列表，与HQL过滤条件中的'?'一一对应
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}

	/**
	 * 查询并准备分页信息（直接返回）
	 * @param pageNum
	 * @param service
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Page buildPageBeanForStruts2(int currentPage, IBaseService service) {
		Page page = service.getPage(currentPage, this);
		return page;
	}
}
