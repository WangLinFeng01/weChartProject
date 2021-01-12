package com.wechat.model.dao.crm;

import java.util.List;
import java.util.Map;

import com.wechat.model.pojo.Label;

public interface LabelDao {
	//获取total
	public int getTotal();
	public void addLabel(Label label);
	public List<Label> pageQueryDate(Map<String, Object> map);

}
