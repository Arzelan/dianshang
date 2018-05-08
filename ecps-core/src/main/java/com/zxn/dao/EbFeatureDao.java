package com.zxn.dao;

import java.util.List;

import com.zxn.model.EbFeature;

public interface EbFeatureDao {
	
	public List<EbFeature> selectIsSpecFeature();
	
	public List<EbFeature> selectnoSpecFeature();
	
	public List<EbFeature> selectisSelectFeature();
	
	public List<EbFeature> selectFeatureAll();
	
	
	

}
