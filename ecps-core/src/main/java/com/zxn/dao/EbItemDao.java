package com.zxn.dao;

import java.util.List;
import java.util.Map;

import com.zxn.model.EbItem;

public interface EbItemDao {
	
	public List<EbItem> selectItemByCondition(Map<String, Object> map);
	
	public Integer selectItemByConditionCount(Map<String, Object> map);
	
	

}
