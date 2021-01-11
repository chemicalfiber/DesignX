package com.designx.po;

/**
 * 管理员用户持久化对象PO
 * @author wangshihao
 *
 */
public class Admin {
	private Integer adminId;
	private String account;
	private String AdminPassword;
	private String adminName;
	private String adminEmail;
	private String adminStatus;
	private Integer start; //分页起始行
	private Integer rows;   //每页行数

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
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
		return "Admin{" +
				"adminId=" + adminId +
				", account='" + account + '\'' +
				", AdminPassword='" + AdminPassword + '\'' +
				", adminName='" + adminName + '\'' +
				", adminEmail='" + adminEmail + '\'' +
				", adminStatus='" + adminStatus + '\'' +
				", start=" + start +
				", rows=" + rows +
				'}';
	}
}
