package com.designx.controller;

import javax.servlet.http.HttpSession;

import com.designx.po.Admin;
import com.designx.service.AdminService;
import com.designx.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 管理员用户控制器类
 * @author wangshihao
 *
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	/** 注入Service */
	@Autowired
	private AdminService adminService;

	/** 跳转到登录页面 */
	@RequestMapping(value="/toLogin.action",method=RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
	
	/**跳转到管理后台首页页面 */
	@RequestMapping(value="/toAdminIndex.action",method=RequestMethod.GET)
	public String toAdminIndex() {
		return "admin/main";
	}
	
	/**登录处理*/
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String account,String password,Model model,HttpSession session) {
		Admin admin = adminService.findAdmin(account, password);
		/** 登录成功 */
		if(admin != null) {
			session.setAttribute("ADMIN_SESSION", admin);
			return "redirect:toAdminIndex.action";
		}
		model.addAttribute("msg","登录失败,请重新输入账号密码");
		return "login";
	}
	
	/**查询管理员列表,如果有搜索条件,则按照搜索条件查询管理员列表 */
	@RequestMapping("/admin/list.action")
	public String findAdminList(@RequestParam(defaultValue="1")int page, 
			@RequestParam(defaultValue="2")int rows, String account,String status,Model model) {
		Page<Admin> pageAdminList = adminService.findAdminList(page, rows, account, status);
		model.addAttribute("page",pageAdminList);
		model.addAttribute("account",account);
		model.addAttribute("status",status);
		return "admin/admin";	
	}
	
	/** 登录退出 */
	@RequestMapping(value="/logout.action")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:toLogin.action";
	}
	
	/** 查看当前登录的管理员信息 */
	@RequestMapping(value = "/admin/toAdminInfo.action")
	public String toAdminInfo(HttpSession session,Model model) {
		Admin adminSession = (Admin)session.getAttribute("ADMIN_SESSION");
		if(adminSession != null) {
			int adminId = adminSession.getAdminId();
			Admin admin = adminService.findAdminById(adminId);
			model.addAttribute("adminInfo",admin);
			return "admin/adminInfo";
		}
		return "redirect:toLogin.action";
	}
	
	/** 修改管理员个人信息,使用@ResponseBody+返回String则返回字符串 */
	@RequestMapping("/admin/update.action")
	@ResponseBody
	public String updateAdmin(Admin admin) {
		int rows = adminService.updateAdmin(admin);
		if(rows > 0) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
	
	/** 修改当前登录的管理员密码 */
	@RequestMapping("/admin/updateAdminPwd.action")
	@ResponseBody
	public String updateAdminPassword(String oldPassword,String password,HttpSession session) {
		Admin adminSession=(Admin)session.getAttribute("ADMIN_SESSION");
		int adminId = 0;
		if(adminSession != null) {
			adminId = adminSession.getAdminId();
		}
		int rows = adminService.updateAdminPassword(adminId,oldPassword,password);
		if(rows > 0) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
	
	/** 创建管理员 */
	@RequestMapping("/admin/add.action")
	@ResponseBody
	public String addAdmin(Admin admin) {
		int rows = adminService.addAdmin(admin);
		if(rows > 0) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
	
	/** 删除管理员 */
	@RequestMapping("/admin/delete.action")
	@ResponseBody
	public String deleteAdmin(int adminId) {
		int rows = adminService.deleteAdmin(adminId);
		if(rows > 0) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
	
	/** 根据id查询管理员详情 */
	@RequestMapping("/admin/edit.action")
	@ResponseBody
	public Admin editAdmin(int adminId,Model model) {
		Admin admin = adminService.findAdminById(adminId);
		return admin;
	}	
	

}


























