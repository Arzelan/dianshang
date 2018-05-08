package com.zxn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxn.dao.EbFeatureDao;
import com.zxn.model.EbFeature;
import com.zxn.service.EbFeatureService;
@Service
public class EbFeatureServiceImpl implements EbFeatureService {
	@Autowired
	EbFeatureDao EbfeartureDao;
	
	public List<EbFeature> selectIsSpecFeature() {
		return EbfeartureDao.selectIsSpecFeature();
	}

	public List<EbFeature> selectnoSpecFeature() {
		return EbfeartureDao.selectnoSpecFeature();
	}

	public List<EbFeature> selectisSelectFeature() {
		return EbfeartureDao.selectisSelectFeature();
	}

	public List<EbFeature> selectFeatureAll() {
		return EbfeartureDao.selectFeatureAll();
	}

}
