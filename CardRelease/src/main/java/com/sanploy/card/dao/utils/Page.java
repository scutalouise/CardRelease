package com.sanploy.card.dao.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:页面参数、封装要在页面显示的对象；
 * @author:scuta
 * @since:2015年7月8日
 * @version:default 0.0.0.1
 */
public class Page<T> {

	public Page() {
		this.pageCount = Page.getPageCount(recordCount, pageSize);
	}

	// 传递的参数或是配置的参数
	private Integer currentPage = 1; // 当前页
	private Integer pageSize = 5; // 每页显示多少条记录,默认值，可以配置到外部配置里去；便于修改；

	// 查询数据库
	private List<T> recordList = new ArrayList<T>(); // 本页的数据列表
	private Integer recordCount = 0; // 总数据个数

	// 计算得到的数据
	private Integer pageCount = 0; // 总页数

	public Page(int currentPage, int pageSize, List<T> recordList, int recordCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordList = recordList;
		this.recordCount = recordCount;
		this.pageCount = Page.getPageCount(recordCount, pageSize);
	}

	/**
	 * 计算显示的页数,特殊数据已被处理,不会报错
	 * 
	 * @param total
	 *            总数据个数
	 * @param pageSize
	 *            每页显示的个数
	 * @return
	 */
	public static Integer getPageCount(Integer recordCount, Integer pageSize) {
		if (recordCount <= 0 || pageSize <= 0) {
			return 0;
		}
		if (recordCount % pageSize == 0) {
			return recordCount / pageSize;
		} else {
			return recordCount / pageSize + 1;
		}
//		另外一种个计算方式
//        if (recordCount > 0) {
//            this.totalCount = totalCount;
//            this.pageCount = (totalCount + pageSize - 1) / pageSize;
//        }
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<T> recordList) {
		this.recordList = recordList;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		// 每次进行总记录的设置时，需要重新计算页数；
		this.pageCount = getPageCount(recordCount, pageSize);
		this.recordCount = recordCount;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

}
