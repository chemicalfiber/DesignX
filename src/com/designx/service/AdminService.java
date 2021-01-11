package com.designx.service;


import com.designx.po.Admin;
import com.designx.util.Page;

/**
 * 管理员Service接口
 * @author wangshihao
 *
 */
public interface AdminService {
	/** 通过账号和密码查询管理员 */
	public Admin findAdmin(String account, String password);
	
	/** 查询管理员列表,page为当前页面,rows为每页行数 */
	public Page<Admin> findAdminList(int page, int rows, String account, String status);
	
	
	/** 修改管理员密码 */
	public int updateAdminPassword(int adminId,String oldPassword,String password);
		
	/** 新增管理员 */
	public int addAdmin(Admin admin);
	
	/** 删除管理员 */
	int deleteAdmin(int adminId);
	
	/** 通过id查询管理员 */
	public Admin findAdminById(int adminId);
	
	/** 修改管理员信息 */
	public int updateAdmin(Admin admin);
	
	
}
















