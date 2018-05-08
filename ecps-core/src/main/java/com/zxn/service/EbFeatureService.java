package com.zxn.service;

import java.util.List;

import com.zxn.model.EbFeature;

public interface EbFeatureService {
public List<EbFeature> selectIsSpecFeature();
	
	public List<EbFeature> selectnoSpecFeature();
	
	public List<EbFeature> selectisSelectFeature();
	
	public List<EbFeature> selectFeatureAll();

}
