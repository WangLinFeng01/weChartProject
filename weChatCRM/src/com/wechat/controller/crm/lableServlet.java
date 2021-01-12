package com.wechat.controller.crm;

import java.awt.Label;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.model.dao.crm.impl.LabelDaoImpl;


public class lableServlet extends HttpServlet {
	 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	response.setContentType("text/html; charset=UTF-8");
    	 
        int start = 0;
        int count = 5;
 
        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
            // 当浏览器没有传参数start时
        }
        //下一页
        int next = start + count;	
        //上一页
        int pre = start - count;
        
        //获取数据库表当中数据的条数
        int total = new LabelDaoImpl().getTotal();
        int sum=0;
        if(total%count==0) {
        	sum=total/count;
        }
        else {
        	sum=(total/count)+1;
        }
        request.setAttribute("sum", sum);
        //初始化页数
        int pages=0;
        pages=start/count+1;
        request.setAttribute("pages", pages);
        
        int last;
        if (0 == total % count)
            last = total - count;
        else
            last = total - total % count;
        //健壮性判断
        pre = pre < 0 ? 0 : pre;
        //健壮性判断
        next = next > last ? last : next;
        //setAttribute 设置 key-value -map
        request.setAttribute("next", next);
        request.setAttribute("pre", pre);
        request.setAttribute("last", last);
        //页面的具体数据
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("start", start);
        map.put("size", count);
        List<com.wechat.model.pojo.Label> label = new LabelDaoImpl().pageQueryDate(map);
        System.out.println("---->"+label);
        request.setAttribute("Label",label);
        //转发 服务器内部资源的调动
        request.getRequestDispatcher("jsp/user/user.jsp").forward(request, response);
    
    }
    
}
