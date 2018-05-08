package com.zxn.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.zxn.dao.EbItemDao;
import com.zxn.model.EbItem;
@Repository
public class EbItemDaoImpl extends SqlSessionDaoSupport implements EbItemDao {

	String ns = "com.zxn.mapper.EbItemMapper.";
	public List<EbItem> selectItemByCondition(Map<String, Object> map) {
		return this.getSqlSession().selectList(ns+"selectItemByCondition", map);
	}

	public Integer selectItemByConditionCount(Map<String, Object> map) {
		return (Integer) this.getSqlSession().selectOne(ns+"selectItemByConditionCount", map);
	}

}
