package com.wechat.model.dao.crm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.wechat.model.dao.crm.UserDao;
import com.wechat.model.dao.crm.base.BaseDaoImpl;
import com.wechat.model.pojo.User;
import com.wechat.utils.JdbcUtil;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	
	@Override
	public void addUser(User user) {
		String sql ="insert into user values(default,?,?,?,?)";
		Object[] params = {user.getUser_name(),user.getOpenid(),user.getHeadimgurl(),null};
		dml(sql,params);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User queryUserById(String openId) {
		String sql="select user_id FROM user where openid=?";
		Object[] obj= {openId};
		return queryForBean(sql, obj);
		
	}

	@Override
	public List<User> queryUserByIags(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> queryUserByLevel(String level) {
		// TODO Auto-generated method stub
		return null;
	}
	//引入sql工具

	@Override
	public User queryUserByUsername(Object[] user_name){
		String sql = "select * from user where user_name like '%"+user_name+"%'";
		Object[] params1=new Object[] {};
		List<User> admin1=queryForList(sql,params1);
		return (User) admin1;
	}
	
	@Override
	public List<User> pageQueryDate(Map<String, Object> map) {
		int start=(int) map.get("start");
		int size=(int) map.get("size");
		String sql = "select headimgurl,user_name,openid from user	limit ?,?";
		Object[] params=new Object[] {start,size};
		List<User> user=queryForList(sql,params);
		return user;
//		String sql = "select id,theme_name,imgurl from material	limit ?,?";
//		if(select != null && select != "" && select instanceof String ) {
//			sql = "select id,theme_name,imgurl from material where theme_name ='"+ select +"' limit ?,?";
//		}
//		Object[] params = {start,count};
//		return super.queryForList(sql, params);
	}

	@Override
	public int getTotal() {
		int total=0;
		Connection conn=null;
		try {
			conn=JdbcUtil.getConnection();
			System.out.println(conn);
			String sql="select count(*) from user";
			Statement s = conn.createStatement();
			 ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                total = rs.getInt(1);
	            }
	 
	            System.out.println("total:" + total);
	 
	            s.close();
	 
	            conn.close();
		} catch (SQLException e) {
            e.printStackTrace();
        }
        return total;

	}
	
	@Override
	public User queryUserByName(String name) {
        String sql="select * from user where user_name=?";
        Object[] obj= {name};
        return queryForBean(sql, obj);
	}
	
}
