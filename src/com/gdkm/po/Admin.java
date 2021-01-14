package com.gdkm.po;

/**
 * 管理员用户持久化对象PO
 * @author wangshihao
 *
 */
public class Admin {
	private Integer adminId;
	private String account;
	private String password;
	private String username;
	private String email;
	private String status;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return "Admin [adminId=" + adminId + ", account=" + account + ", password=" + password + ", username="
				+ username + ", email=" + email + ", status=" + status + "]";
	}
	
}
