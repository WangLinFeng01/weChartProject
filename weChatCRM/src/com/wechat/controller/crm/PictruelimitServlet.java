package com.wechat.controller.crm;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.model.dao.crm.MaterialDao;
import com.wechat.model.dao.crm.impl.MaterialDaoImpl;
import com.wechat.model.pojo.Material;

@WebServlet("/PictruelimitServlet")
public class PictruelimitServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
        
		//method=delect&start_id
		String method = request.getParameter("method");
		if(method!=null) {
			switch(method) {
			//删除图片
			case "delect": delectPicture(request, response);break;
			}
		}
		
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
        
        //获取数据库素材表当中数据的条数
        int total = new MaterialDaoImpl().getTotal();
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
        //查询出分页的数据
        List<Material> material = new MaterialDaoImpl().pageQueryDate(start,count);
        System.out.println("分页执行");
        request.setAttribute("material",material);
        //转发 服务器内部资源的调动
        request.getRequestDispatcher("jsp/user/picture.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	//删除数据库中的图片，
	public void delectPicture(HttpServletRequest request, HttpServletResponse response) {
		String start_id = request.getParameter("start_id");
		if(start_id != null) {
			MaterialDao metaialdao = new MaterialDaoImpl(); 
			metaialdao.delectImgUrl(Integer.parseInt(start_id));
		}
		
	}
}
