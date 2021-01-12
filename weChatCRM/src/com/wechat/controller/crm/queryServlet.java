package com.wechat.controller.crm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.model.dao.crm.UserDao;
import com.wechat.model.dao.crm.impl.UserDaoImpl;
import com.wechat.model.pojo.Admin;

public class queryServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("queryText");
		UserDao mpl=new UserDaoImpl();
		Object[] user_name= {};
		List<Admin> list=(List<Admin>) mpl.queryUserByUsername(user_name);
		System.out.println(name);
		request.setAttribute("persons",list);
	    //转发 服务器内部资源的调动
	    request.getRequestDispatcher("jsp/user/user.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
