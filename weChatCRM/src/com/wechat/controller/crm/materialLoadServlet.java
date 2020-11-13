package com.wechat.controller.crm;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wechat.model.dao.crm.MaterialDao;
import com.wechat.model.dao.crm.impl.MaterialDaoImpl;
import com.wechat.model.pojo.Material;
import com.wechat.utils.ImageUtil;



/**
 * 这是一个实现添加素材图片，上传到Tomcat编译后的路径的servlet
 */
@WebServlet("/materialLoadServlet")
public class materialLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//到这里为止，省掉中间的步骤，前端页面只是传输了存储在request中的新增分类中的图片名称和图片的相对地址的信息
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> params = new HashMap<>();
		InputStream is = this.parseUpload(request, params);
		System.out.println("filepath:"+request.getParameter("filepath"));
		
		String name= params.get("name");//拿到的主题名称，用来做查询并做插入到meterial之中，拿到id值。
		
		System.out.println(name);
		//拿到对象
		MaterialDao md = new MaterialDaoImpl();
		
		//得到上传到Tomcat服务器上的图片的相对地址 --- 以当前时间命名
		String absPath = "img/"+System.currentTimeMillis()+".jpg";
		Material m = new Material(name,absPath);
		
		//上传到数据库中
		md.add(m);//将增加的图片添加到数据库中。
		
		File  imageFolder= new File(request.getSession().getServletContext().getRealPath(absPath));
		System.out.println("meterialLoadServlet中图像的调试路径："+imageFolder);
		//D:\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\mall\img
		try {
			if(null!=is && 0!=is.available()){
			    try(FileOutputStream fos = new FileOutputStream(imageFolder)){
			        byte b[] = new byte[1024 * 1024];
			        int length = 0;
			        while (-1 != (length = is.read(b))) {
			            fos.write(b, 0, length);
			        }
			        fos.flush();
			        //通过如下代码，把文件保存为jpg格式
			        BufferedImage img = ImageUtil.change2jpg(imageFolder);
			        ImageIO.write(img, "jpg", imageFolder);		
			    }
			    catch(Exception e){
			    	e.printStackTrace();
			    }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/PictruelimitServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	public InputStream parseUpload(HttpServletRequest request, Map<String, String> params) {
		InputStream is =null;
		try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置上传文件的大小限制为10M
            factory.setSizeThreshold(1024 * 10240);
             
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    // item.getInputStream() 获取上传文件的输入流
                    is = item.getInputStream();
                } else {
                	//获取到存储在request中表单中不是文件提交的的name名以及value值。
                	String paramName = item.getFieldName();//name
                	
                	String paramValue = item.getString();//è·³è±
                	//对字符编码格式处理
                	paramValue = new String(paramValue.getBytes("ISO-8859-1"), "UTF-8");//跳脱
                	params.put(paramName, paramValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return is;
	}

}
