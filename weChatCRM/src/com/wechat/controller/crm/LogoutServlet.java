package com.wechat.controller.crm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, 
             HttpServletResponse response)
            throws ServletException, IOException {
        //1.用户注销
        request.getSession().removeAttribute("user");
        //2.从客户端删除自动登录的cookie
        Cookie cookie = new Cookie("autologin", "msg");
        cookie.setPath(request.getContextPath());
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect(request.getContextPath()+"/index.jsp"); 
    }
    public void doPost(HttpServletRequest request,
         HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
