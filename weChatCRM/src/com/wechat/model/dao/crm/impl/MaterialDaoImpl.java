package com.wechat.model.dao.crm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wechat.model.dao.crm.MaterialDao;
import com.wechat.model.dao.crm.base.BaseDaoImpl;
import com.wechat.model.pojo.Material;
import com.wechat.utils.JdbcUtil;


public class MaterialDaoImpl extends BaseDaoImpl<Material> implements MaterialDao{

	@Override
	public void add(Material m) {
		String sql="insert into material values(null,?,?)"; 
		Object[] params= {m.getTheme_name(),m.getImgurl()};
		super.dml(sql, params);
	}

	//查询多条数据
	@Override
	public List<Material> querylistBean(Material meterial) {
		String sql = "select id,theme_name,imgurl from material";
		return super.queryForList(sql, null);
		
	}

	//查询数据库material表中数据的条数
	public int getTotal() {
		int total = 0;
		String sql = "select count(id) from material";
		
        Connection conn = null;
		try {
			conn = JdbcUtil.getConnection();
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				 total = rs.getInt(1);
			}
			JdbcUtil.close(conn, s, rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return total;
		}
	}

	//分页查询
	public List<Material> pageQueryDate(int start, int count,String select) {
		String sql = "select id,theme_name,imgurl from material	limit ?,?";
		if(select != null && select != "" && select instanceof String ) {
			sql = "select id,theme_name,imgurl from material where theme_name ='"+ select +"' limit ?,?";
		}
		Object[] params = {start,count};
		return super.queryForList(sql, params);
	}

	//根据id删除数据
	@Override
	public void delectImgUrl(Integer id) {
		String sql = "delete from material where id = ?";
		Object[] params = {id};
		super.dml(sql, params);
	}

}
