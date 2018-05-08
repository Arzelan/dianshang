package com.zxn.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.zxn.dao.EbBrandDao;
import com.zxn.model.EbBrand;
@Repository
public class EbBrandDaoImpl extends SqlSessionDaoSupport implements EbBrandDao {

	String ns = "com.zxn.mapper.EbBrandMapper.";
	public void saveBrand(EbBrand brand) {
		this.getSqlSession().insert(ns+"insert", brand);
	}

	public void updateBrand(EbBrand brand) {
		this.getSqlSession().update(ns+"updateByPrimaryKeySelective", brand);
	}

	public EbBrand getBrandById(Long brandId) {
		return (EbBrand) this.getSqlSession().selectOne(ns+"selectByPrimaryKey", brandId);
	}

	public void deleteBrand(Long brandId) {
		this.getSqlSession().delete(ns+"deleteByPrimaryKey", brandId);
	}

	public List<EbBrand> selectBrandAll() {
		return this.getSqlSession().selectList("selectBrandAll");
	}

	public List<EbBrand> selectBrandByName(String brandName) {
		return this.getSqlSession().selectList(ns+"selectBrandByName", brandName);
	}

}
