package com.wechat.utils;

import com.wechat.model.bean.Button;
import com.wechat.model.bean.CleckButton;
import com.wechat.model.bean.PhotoBtn;
import com.wechat.model.bean.SubButton;
import com.wechat.model.bean.viewButton;
import com.wechat.model.configuration.TokenConfig;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

public class CreateMenu {
	public static void main(String[] args) {
		creatMenu();
		//deletMenu();
	}
	public static void creatMenu() {
		//菜单对象
		Button btn = new Button();
		//第一个一级菜单
		btn.getButton().add(new CleckButton("查看榜单", "Help"));
		//第二个一级菜单
		btn.getButton().add(new viewButton("一级跳转", "http://www.baidu.com"));
		//创建第三个一级菜单怎加子菜单
		SubButton sb = new SubButton("有子菜单");
		//为第三个一级菜单增加子菜单
		sb.getSub_button().add(new PhotoBtn("传图", "31"));
		sb.getSub_button().add(new CleckButton("点击", "32"));
		sb.getSub_button().add(new viewButton("网易新闻", "http://news.163.com"));
		//加入第三个一级菜单
		btn.getButton().add(sb);
		//转为json
		String jsonObject = new JSONObject(btn).toString();
		System.out.println(jsonObject.toString());
		//准备url
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		url=url.replace("ACCESS_TOKEN", TokenConfig.getAccessToken());
		//发送请求
		String result= TokenConfig.post(url, jsonObject);
		System.out.println(result);
	}
	public static void deletMenu() {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
		url=url.replace("ACCESS_TOKEN", TokenConfig.getAccessToken());
		String res=HttpUtil.get(url);
		System.out.println(res);
	}
}
