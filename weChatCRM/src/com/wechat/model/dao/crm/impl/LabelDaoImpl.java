package com.wechat.model.dao.crm.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.wechat.model.dao.crm.LabelDao;
import com.wechat.model.dao.crm.base.BaseDaoImpl;
import com.wechat.model.pojo.Label;
import com.wechat.utils.JdbcUtil;

public class LabelDaoImpl extends BaseDaoImpl<Label> implements LabelDao{

	@Override
	public void addLabel(Label label) {
         String sql="insert into label values(default,?,?,?)";
         Object[] obj = {label.getUser_id(),label.getLabel_name(),label.getLabel_count()};
         dml(sql, obj);
	}
    @Override
    public int getTotal() {
    	int total=0;
    	Connection conn=null;
    	try {
    		conn=JdbcUtil.getConnection();
    		System.out.println(conn);
    		String sql="select count(*) from label";
    		java.sql.Statement s = conn.createStatement();
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
    public List<Label> pageQueryDate(Map<String, Object> map) {
    	Connection conn=JdbcUtil.getConnection();
    	int start=(int) map.get("start");
    	int size=(int) map.get("size");
    	String sql = "select * from label order by id desc limit ?,? ";
    	Object[] params=new Object[] {start,size};
    	List<Label> label=queryForList(sql,params);
    	return label;
    }
}