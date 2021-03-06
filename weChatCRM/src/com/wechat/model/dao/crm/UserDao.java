package com.wechat.model.dao.crm;

import java.util.List;
import java.util.Map;

import com.wechat.model.dao.crm.base.BaseDao;
import com.wechat.model.pojo.User;

public interface UserDao {
	//获取total
	public int getTotal();
	//添加用户
	public void addUser(User user);
	//修改用户
	public void updateUser(User user);
	//根据openID查询信息
	public User queryUserById(String openId);
	//根据用户名查media_id
	public User queryUserByName(String name);
	//根据标签来查询用户
	public List<User> queryUserByIags(String tag);
	//根据等级来查询用户，返回多条数据
	public List<User> queryUserByLevel(String level);
	//根据用户姓名，查找数据
	public User queryUserByUsername(Object[] user_name);
	//来查询多条数据
	public List<User> pageQueryDate(Map<String, Object> map);
	
}
