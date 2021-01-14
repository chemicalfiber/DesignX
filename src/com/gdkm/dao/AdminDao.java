package com.gdkm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gdkm.po.Admin;

/**
 * admin的Dao接口
 * @author wangshihao
 *
 */
public interface AdminDao {
	//登录,按照账号和密码查询admin用户
	public Admin findAdmin(@Param("account") String account, 
						   @Param("password") String password);
	
	//查询管理员列表
	public List<Admin> findAdminList(Admin admin);
	
	//查询管理员数量
	public int findAdminListCount(Admin admin);
	
	//修改管理员密码
	public int updateAdminPassword(@Param("adminId") int adminId,
								   @Param("oldPassword") String oldPassword,
								   @Param("password") String password);
	
	//创建管理员
	public int addAdmin(Admin admin);
	
	//删除管理员
	int deleteAdmin(int adminId);
	
	//通过id查询管理员
	public Admin findAdminById(int adminId);
	
	//修改管理员信息
	public int updateAdmin(Admin admin);
	
}
