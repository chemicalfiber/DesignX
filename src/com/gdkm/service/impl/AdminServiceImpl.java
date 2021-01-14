package com.gdkm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdkm.dao.AdminDao;
import com.gdkm.po.Admin;
import com.gdkm.service.AdminService;
import com.gdkm.util.Page;

/**
 * 管理员用户Service接口的实现类
 * @author wangshihao
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	//注入Dao
	@Autowired
	private AdminDao adminDao;  
	
	//通过账号密码查询管理员用户
	@Override
	public Admin findAdmin(String account, String password) {
		Admin admin = adminDao.findAdmin(account, password);
		return admin;
	}

	//查询管理员列表,page为当前页面,rows为每页行数
	@Override
	public Page<Admin> findAdminList(int page, int rows, String account, String status) {
		Admin admin = new Admin();
		if(StringUtils.isNotBlank(account)) {  //判断账号不为空
			admin.setAccount(account);
		}
		if(StringUtils.isNotBlank(status)) {  //判断状态不为空
			admin.setStatus(status);
		}
		admin.setStart((page - 1) * rows); 
		admin.setRows(rows); //设置每页行数
		List<Admin> adminList = adminDao.findAdminList(admin);
		int count = adminDao.findAdminListCount(admin);
		Page<Admin> pageAdminList = new Page<Admin>();
		pageAdminList.setPage(page);
		pageAdminList.setRows(adminList);
		pageAdminList.setSize(rows);
		pageAdminList.setTotal(count);
		return pageAdminList;
	}

	//修改管理员密码
	@Override
	public int updateAdminPassword(int adminId,String oldPassword,String password) {
		return adminDao.updateAdminPassword(adminId, oldPassword, password);
	}
	
	//新增管理员
	@Override
	public int addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	//删除管理员
	@Override
	public int deleteAdmin(int adminId) {
		return adminDao.deleteAdmin(adminId);
	}

	//通过id查询管理员
	@Override
	public Admin findAdminById(int adminId) {
		return adminDao.findAdminById(adminId);
	}

	//修改管理员信息
	@Override
	public int updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}


}
