package com.gdkm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gdkm.po.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台登录拦截器
 * @author wangshihao
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView arg3)
			throws Exception {	
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI(); //获取请求的URL
		//URL:除了登录请求之外,其他的URL都进行拦截访问
		if(url.indexOf("/admin/login.action") >= 0) {
			return true;
		}
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("ADMIN_SESSION");
		//判断Session中是否有用户数据,如果有,则返回true,继续向下执行
		if(admin != null) {
			return true;
		}
		//不符合条件的给出提示信息,并转发到登录页面
		request.setAttribute("msg", "您还没有登录,请先登录!");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

}
