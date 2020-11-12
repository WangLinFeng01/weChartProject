package com.wechat.model.configuration;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;

import com.wechat.model.bean.AccessToken;
import com.wechat.model.bean.UserInfo;
import com.wechat.model.dao.crm.Dm_tableDao;
import com.wechat.model.dao.crm.UserDao;
import com.wechat.model.dao.crm.impl.Dm_tableDaoImpl;
import com.wechat.model.dao.crm.impl.UserDaoImpl;
import com.wechat.model.factory.DaoFactory;
import com.wechat.model.pojo.Dm_table;
import com.wechat.model.pojo.User;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class TokenConfig {
	
	private static String accessTokenUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static String APPID = "wx0f53c5158940518e";
	private static String APPSECRET="dc415f54572a401b9f31c8e26b08a99b";
	
	//客服的URL
	private  String customerUrl = " https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	
	//用get方式获取用户基本信息的URL
	private  String getUerInfoUrl=" https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	
	//临时二维码生成的URL
	private  String qrcodeCreateUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
	
	//生成临时二维码后进行ticket获取二维码的URL
	private  String getQrcodeCreateUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
	private static AccessToken at = null;
	public static UserInfo ui = null;
	
	
	//access_token是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token,初始化access_token
	private static AccessToken initToken() {
		
		//替换accessTokenUrl -- APPID -APPSECRET
		String url = accessTokenUrl.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		
		//从微信服务器获取对应的权限  接口调用请求---get请求
		//{"access_token":"ACCESS_TOKEN","expires_in":7200}
		String tokenStr = HttpUtil.get(url);
		
		//解析服务器中发送过来的json请求
		JSONObject jsonObject = JSONUtil.parseObj(tokenStr);
		
		//取出其中的值token和expire
		String token = jsonObject.getStr("access_token");
		String expireIn = jsonObject.getStr("expires_in");
		
		//将取出的值放到AccessToken中
		at = new AccessToken(token,expireIn);
		System.out.println("accessToken:"+at.getAccessToken());
		return at;
	}
	
	//对外暴露一个方法，可以得到经过验证后返回的AccessToken值。
	public static String getAccessToken() {
		if(at==null|| at.expiredStatus()) {
			initToken();
		}
		return at.getAccessToken();
	}
	
	//获取客服的URL信息
	public static String getCustomerUrl() {
		TokenConfig tc = new TokenConfig();
		String ss = null;
		//替换accessToken
		ss = tc.customerUrl.replace("ACCESS_TOKEN",TokenConfig.getAccessToken());
		return ss;
	}
	//得到用户基本信息
	public static UserInfo getUserInfoUrl(Map<String, String> xmlMap) {
		if(ui==null) {
			return ui=initUserInfoUrl(xmlMap);
		}else
		return ui;
	}
	//初始化一个获取用户基本信息的方法
	public static UserInfo initUserInfoUrl(Map<String, String> xmlMap) {
		TokenConfig tc = new TokenConfig();
		String ss = null;
		String opendid=xmlMap.get("FromUserName");
		//替换每个访问用户的openID
		ss = tc.getUerInfoUrl.replace("ACCESS_TOKEN",TokenConfig.getAccessToken()).replace("OPENID",xmlMap.get("FromUserName"));
		//从微信服务器获取对应的权限  接口调用请求---get请求
		String uerInfoStr = HttpUtil.get(ss);
		//解析服务器中发送过来的json请求
		JSONObject jsonObject = JSONUtil.parseObj(uerInfoStr);
		//取出其中用户的昵称和头像
		String nickName = jsonObject.getStr("nickname");
		String headImgUrl = jsonObject.getStr("headimgurl");
		//将取出的值放到UserInfo中
		UserInfo uif = new UserInfo(nickName,headImgUrl);
		System.out.println("当前的用户是："+uif.getNickName());
		UserDao ud=new UserDaoImpl();
		//判断数据库里是否存在这个扫描用户
		if(ud.queryUserById(opendid)==null) {
		//封装user
	    User user=new User(nickName, opendid, headImgUrl);
	    //将user存入数据库
	    ud.addUser(user);
		return uif;
		}else {
			System.out.println("已存在");
			//存在就直接发送素材表中的海报给用户不重新生成
			//拿到user_id
			int user_id=ud.queryUserByName(nickName).getUser_id();
			Dm_tableDao dd=new Dm_tableDaoImpl();
			//拿到media_id
			Dm_table dtable=dd.queryDm_tableDaobyuserId(user_id);
			String media_id=dtable.getMedia_id();
			//素材库中的素材过期
			System.out.println(dtable.getExpirationTime().getTime());
			System.out.println(new Date().getTime());
			if(dtable.getExpirationTime().getTime()-new Date().getTime()<0) {
				return uif;
			}else {
				//客服回复海报的xml格式的String字符串
				String url = TokenConfig.getCustomerUrl();
		        String customerResultXml = TexTemplate.getCustomerImgTemplate(media_id, xmlMap);
		        //发送临时素材库的海报给用户
		        HttpUtil.post(url, customerResultXml);	
		        //终止程序
		        System.exit(0);
			}
		}
		return null;
	}
	

	
	
	//响应菜单数据的post请求方法
		public static String post(String url,String data) {
			
			try {
				URL urlObj = new URL(url);
				URLConnection connection = urlObj.openConnection();
				//要发送数据出去，必须要设置为可发送数据状态
				connection.setDoOutput(true);
				//获取输出流
				OutputStream os = connection.getOutputStream();
				//写出数据
				os.write(data.getBytes());
				os.close();
				//获取输入流
				InputStream is = connection.getInputStream();
				byte[] b = new byte[1024];
				int len;
				StringBuilder sb = new StringBuilder();
				while((len=is.read(b))!=-1) {
					sb.append(new String(b,0,len));
				}
				return sb.toString();
		
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
			
			
		}
	
	//生成临时二维码并获取这个二维码的url
	public static String getQrcode(Map<String, String> xmlMap) {
		TokenConfig tc = new TokenConfig();
		String ss = null;
		//替换字符串
		ss = tc.qrcodeCreateUrl.replace("TOKEN", TokenConfig.getAccessToken());
		//发送的Post请求替换
		String postExpires ="{\"expire_seconds\": 604800, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""+xmlMap.get("FromUserName")+"\"}}}";
		//提交post并返回json
		String jsons = HttpUtil.post(ss, postExpires);
		
		//从jsons中获取到这个用户对应二维码

		//解析服务器中发送过来的json请求
		JSONObject jsonObject = JSONUtil.parseObj(jsons);
		
		//取出其中ticket
		String ticket = jsonObject.getStr("ticket");
		
		//TICKET进行UrlEncode
		ticket =  java.net.URLEncoder.encode(ticket);
		String sss = null;
		//替换这个获取二维码的URL
		sss = tc.getQrcodeCreateUrl.replace("TICKET", ticket);
		//返回这个二维码的URL
		return sss;
	}
	
		//处理二维码下载到本地服务器中 ,返回下载下来图片所在的相对路径
		public static String downlocalQrcodeImg(Map<String, String> xmlMap) {
			
			String QrcodeImgUrl = TokenConfig.getQrcode(xmlMap);
			//将文件下载后保存在服务器，返回结果为下载文件大小
			String imgStr = "../../img/"+TokenConfig.getUserInfoUrl(xmlMap).getNickName()+"/ticket.jpg";
			HttpUtil.downloadFile(QrcodeImgUrl, FileUtil.file(imgStr));
			String headName = imgStr;
			return headName;
		}
	
}









