package com.wechat.controller.crm;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.wechat.model.dao.crm.AdminDao;
import com.wechat.model.dao.crm.UserDao;
import com.wechat.model.dao.crm.impl.AdminDaoImpl;
import com.wechat.model.dao.crm.impl.UserDaoImpl;
import com.wechat.model.pojo.Admin;

public class registerServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//获取链接
			String admin_name=request.getParameter("loginacct");
			String password=request.getParameter("userpasswd");
			String email=request.getParameter("email");

    		//获取到数据库中的name的集合
    		//判断用户账号是否重复
			AdminDao mpl=new AdminDaoImpl();
			Object[] params=null;
			List<Admin> list=mpl.QueryAdmin(params);
    		System.out.println(list);
    		if(list.get(0).getAdmin_name().equals(admin_name)&&list.get(1).getPassword().equals(password)&&list.get(2).getEmail().equals(email)) {
    	    	JOptionPane.showMessageDialog(null, "该用户已存在，请重新输入");
    	    	response.sendRedirect(request.getContextPath()+"/jsp/register.jsp");
    	    	return;
    		}
			mpl.addAdmin(admin_name, password, email);
			JOptionPane.showMessageDialog(null, "注册成功");
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      doGet(req, resp);
	}

}
