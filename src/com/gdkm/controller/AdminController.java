package com.gdkm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdkm.po.Admin;
import com.gdkm.service.AdminService;
import com.gdkm.util.Page;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
   
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/toLogin.action",method=RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
	@RequestMapping(value="/toAdminIndex.action",method=RequestMethod.GET)
	public String toAdminIndex() {
		return "admin/main";
	}
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String account,String password,
			             Model model,HttpSession session) {
		Admin admin=adminService.findAdmin(account, password);
		if(admin !=null) {
			session.setAttribute("ADMIN_SESSION", admin);
			return "redirect:toAdminIndex.action";
		}
		model.addAttribute("msg", "登录的账号和密码错误，请重新输入");
		return "login";
	}
	@RequestMapping(value="logout.action")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:toLogin.action";
	}
	//查询管理员列表，如果有搜索条件，则按照条件查询管理员列表
		@RequestMapping("/admin/list.action")
		public String findAdminList(@RequestParam(defaultValue="1")int page,
				@RequestParam(defaultValue="2")int rows,String account,String status,Model model) {
			Page<Admin> pageAdminList= adminService.findAdminList(page, rows, account, status);
			model.addAttribute("page",pageAdminList);
			model.addAttribute("account",account);
			model.addAttribute("status",status);
			return "admin/admin";
		}
	/**--- 当前后台登陆用户信息管理---**/
	@RequestMapping(value="/admin/toAdminInfo.action")
	public String toAdminInfo(HttpSession session,Model model) {
		Admin adminSession=(Admin)session.getAttribute("ADMIN_SESSION");
		if(adminSession!=null) {
			int adminId=adminSession.getAdminId();
			Admin admin=adminService.findAdminById(adminId);
			model.addAttribute("adminInfo", admin);
			return "admin/adminInfo";
		}
		return "redirect:toLogin.action";
	}
	
	//修改管理员个人信息，使用@ResponseBody+返回String则返回字符串
	@RequestMapping("/admin/update.action")
	@ResponseBody
	public String updateAdmin(Admin admin) {
		int rows = adminService.updateAdmin(admin);
		if(rows >0) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
	@RequestMapping("/admin/updateAdminPwd.action")
	@ResponseBody
	public String updateAdminPassword(String oldPassword,String password,HttpSession session) {
		Admin adminSession=(Admin)session.getAttribute("ADMIN_SESSION");
		int adminId=0;
		if(adminSession !=null) {
			adminId=adminSession.getAdminId();
		}
		int rows = adminService.updateAdminPassword(adminId, oldPassword, password);
		if(rows>0) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
	/**--- 管理员用户信息管理---**/
	//创建管理员
	@RequestMapping("/admin/add.action")
	@ResponseBody
	public String addAdmin(Admin admin) {
		int rows = adminService.addAdmin(admin);
		if(rows >0) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
	//删除管理员
	@RequestMapping("/admin/delete.action")
	@ResponseBody
	public String deleteAdmin(int adminId) {
		int rows = adminService.deleteAdmin(adminId);
		if(rows >0) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
	//根据id查询管理员详情
	@RequestMapping("/admin/edit.action")
	@ResponseBody
	public Admin editAdmin(int adminId,Model model) {
		Admin admin = adminService.findAdminById(adminId);
		return admin;
	}
	}
