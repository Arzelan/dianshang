package com.zxn.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.zxn.dao.EbFeatureDao;
import com.zxn.model.EbFeature;

@Repository
public class EbFeatrueDaoImpl extends SqlSessionDaoSupport implements EbFeatureDao {
	String ns = "com.zxn.mapper.EbFeatureMapper.";
	public List<EbFeature> selectIsSpecFeature() {
		return this.getSqlSession().selectList(ns+"selectisSpecFeature");
	}

	public List<EbFeature> selectnoSpecFeature() {
		return this.getSqlSession().selectList(ns+"selectnoSpecFeature");
	}

	public List<EbFeature> selectisSelectFeature() {
		return this.getSqlSession().selectList(ns+"selectisSelectFeature");
	}

	public List<EbFeature> selectFeatureAll() {
		return this.getSqlSession().selectList(ns+"selectFeatureAll");
	}

}
