package com.gdkm.po;

import java.util.List;

public class NewsColumn {

	private Integer newsColumnId; //ID
	private List<News> newsList;  //栏目关联新闻
	private String columnCode;   //栏目编码
	private String columnName;   //栏目名称
	private String status;       //状态
	private Integer start;       //分页起始行
	private Integer rows;        //每页行数
	public Integer getNewsColumnId() {
		return newsColumnId;
	}
	public void setNewsColumnId(Integer newsColumnId) {
		this.newsColumnId = newsColumnId;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	public String getColumnCode() {
		return columnCode;
	}
	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "NewsColumn [newsColumnId=" + newsColumnId + ", newsList=" + newsList + ", columnCode=" + columnCode
				+ ", columnName=" + columnName + ", status=" + status + ", start=" + start + ", rows=" + rows + "]";
	}
	
}
