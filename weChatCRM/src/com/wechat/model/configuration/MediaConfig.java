package com.wechat.model.configuration;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.wechat.model.dao.crm.Dm_tableDao;
import com.wechat.model.dao.crm.UserDao;
import com.wechat.model.dao.crm.impl.Dm_tableDaoImpl;
import com.wechat.model.dao.crm.impl.UserDaoImpl;
import com.wechat.model.pojo.Dm_table;
import com.wechat.utils.ImageUtil;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class MediaConfig {
	//上传临时素材的URL
	private static String mediaUploadUrl = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	//上传临时素材的方法  fileUrl --- 图片的存放地址的字符串表示
	public static String uploadTempMaterial(String type,String fileUrl) {
	
		//创建本地文件
		HashMap<String, Object> paramMap = new HashMap<>();
		//文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
		paramMap.put("file", FileUtil.file(fileUrl));
        
        //2.拼接请求url
        mediaUploadUrl=mediaUploadUrl.replace("ACCESS_TOKEN", TokenConfig.getAccessToken())
                .replace("TYPE", type);
        
        //3.调用接口，发送请求，上传文件到微信服务器    
        //{"type":"TYPE","media_id":"MEDIA_ID","created_at":123456789}
        String resultStr=HttpUtil.post(mediaUploadUrl, paramMap);
        
        //解析服务器中发送过来的json请求
  		JSONObject jsonObject = JSONUtil.parseObj(resultStr);
  		
  		//取出其中的media_id
  		String media_id = jsonObject.getStr("media_id");
  		UserDao ud=new UserDaoImpl();
  		//得到用户id
  		int user_id=ud.queryUserByName(TokenConfig.ui.getNickName()).getUser_id();
  		//封装Dm_table
  		Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, 3);// 今天+3天
        Date finishTime = c.getTime();
        Dm_table dt=new Dm_table(media_id, user_id, new Date(), finishTime);
        Dm_tableDao dd=new Dm_tableDaoImpl();
        //添加信息到dm_table
        dd.addDm_tableDao(dt);
        return media_id;
	}
	//处理用户头像，下载到本地服务器中 ,返回下载下来图片所在的相对路径
	public static String downLoadHeadImg(Map<String, String> xmlMap) {
		
		//TODO 用户头像 的地址中，应该每次都有一个变量来存储这个地址
		String headerImgUrl = TokenConfig.getUserInfoUrl(xmlMap).getHeadImgUrl()+"/"+xmlMap.get("FromUserName")+".jpg";
		//创建img
		String imgStr = "../../img/"+TokenConfig.getUserInfoUrl(xmlMap).getNickName()+"";
		ImageUtil.createFiles(FileUtil.file(imgStr));
		//将文件下载后保存在服务器，返回结果为下载文件大小
		HttpUtil.downloadFile(headerImgUrl, FileUtil.file(imgStr));
		System.out.println("调试路径：用户头像的绝对路径是"+FileUtil.file(imgStr).getAbsolutePath());
		String headName = imgStr+headerImgUrl.substring(headerImgUrl.lastIndexOf("/"));
		return headName;
	}
	
}
