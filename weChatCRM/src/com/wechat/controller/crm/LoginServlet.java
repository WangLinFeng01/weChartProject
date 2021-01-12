package com.wechat.controller.crm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.wechat.model.dao.crm.AdminDao;
import com.wechat.model.dao.crm.impl.AdminDaoImpl;
import com.wechat.model.pojo.Admin;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, 
             HttpServletResponse response)
            throws ServletException, IOException {
        //1.获得用户名和密码
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("loginacct");
        String password = request.getParameter("userpasswd");
        AdminDao admin=new  AdminDaoImpl();
        Object[] params= {username};
        List<Admin> list=admin.QueryAdmin1(params);
        System.out.println(list);
        if(list==null) {
        	request.setAttribute("errerMsg", "用户不存在，请注册！");
		    response.sendRedirect(request.getContextPath()+"/jsp/register.jsp");
		    return;
        }
        //2.验证输入用户名和密码是否正确
		if (list.get(0).getAdmin_name().equals(username) && list.get(0).getPassword().equals(password)) {
		    //3.将用户状态 user 对象存入 session域
		    Admin user = new Admin(0, password, password, password, password, password);
		    user.setAdmin_name(username);
		    user.setPassword(password);
		    request.getSession().setAttribute("user", user);
		    //4.发送自动登录的cookie
		    String autoLogin = request.getParameter("autologin");
		    if (autoLogin != null) {
		        //5.注意 cookie 中的密码要加密
		        Cookie cookie = new Cookie("autologin", username + "-"
		                + password);
		        cookie.setMaxAge(Integer.parseInt(autoLogin));
		        cookie.setPath(request.getContextPath());
		        response.addCookie(cookie);
		    }
		//6.跳转至首页    
		JOptionPane.showMessageDialog(null, "登录成功");
		response.sendRedirect(request.getContextPath()+"/jsp/main.jsp");
		} else {
		    request.setAttribute("errerMsg", "用户名或密码错");
		    response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		}

    }
    public void doPost(HttpServletRequest request, 
          HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}