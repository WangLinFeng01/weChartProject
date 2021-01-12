package com.wechat.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginFilter implements Filter{
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 获得一个名为 autologin 的cookie
		Cookie[] cookies = request.getCookies();
		System.out.println(cookies);
		String autologin = null;
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if ("autologin".equals(cookies[i].getName())) {
				// 找到了指定的cookie
				autologin = cookies[i].getValue();
				break;
			}
		}
		if (autologin != null) {
//			// 做自动登录
//			String[] parts = autologin.split("-");
//			String account = parts[0];
//			String userName = parts[1];
//			// 检查用户名和密码
//			if ("zhangsan".equals(account)&& ("123456").equals(userName)) {
//				// 登录成功,将用户状态 user 对象存入 session域
//				Person user = new Person();
//				user.setAccount(account);
//				user.setUserName(userName);
//				request.getSession().setAttribute("user", user);
//			}
			request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
		}
		// 放行
		chain.doFilter(request, response);
	}
	public void destroy() {
	}

}
