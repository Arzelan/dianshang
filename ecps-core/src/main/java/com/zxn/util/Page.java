package com.zxn.util;

import java.util.List;

public class Page {
	/**
	 * 当前条件总记录数（已知）
	 */
	int totalCount = 0;
	/**
	 * 每页记录数（已知）
	 */
	int pageSize = 10;
	/**
	 * 当前页码（已知）
	 */
	int pageNo = 1;
	
	int startNum = 0;
	
	int endNum = 0;
	
	int totalPage = 1;
	
	List<?> list;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getStartNum() {
		return (pageNo - 1)*pageSize;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return pageNo*pageSize + 1;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getTotalPage() {
		totalPage = totalCount/pageSize;
		if(totalCount%pageSize == 0){
			return totalPage;
		}else{
			return ++totalPage;
		}
		
		
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	

}
