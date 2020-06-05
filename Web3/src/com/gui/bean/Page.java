package com.gui.bean;

import java.util.List;

public class Page {
	private int totalNum;//数据总数
	private int pageSize;//页面大小
	private int pageNum;//页面数量
	private int currentPage;//当前页码
	private List<Employee> currentObj;//当前页对象集合
	
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.pageNum = this.totalNum / this.pageSize == 0 ? this.totalNum / this.pageSize:this.totalNum / this.pageSize + 1;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Employee> getCurrentObj() {
		return currentObj;
	}
	public void setCurrentObj(List<Employee> currentObj) {
		this.currentObj = currentObj;
	}
	
	
}
