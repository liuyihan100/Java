package com.gui.bean;

import java.util.List;

public class Page {
	private int totalNum;//��������
	private int pageSize;//ҳ���С
	private int pageNum;//ҳ������
	private int currentPage;//��ǰҳ��
	private List<Employee> currentObj;//��ǰҳ���󼯺�
	
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
