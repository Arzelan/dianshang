package com.zxn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxn.dao.EbBrandDao;
import com.zxn.model.EbBrand;
import com.zxn.service.EbBrandService;
//@Service(value="ff")
@Service
public class EbBrandServiceImpl implements EbBrandService {

	@Autowired
	EbBrandDao brandDao;
	
	public void saveBrand(EbBrand brand) {
		brandDao.saveBrand(brand);
	}

	public void updateBrand(EbBrand brand) {
		brandDao.updateBrand(brand);
	}

	public EbBrand getBrandById(Long brandId) {
		return brandDao.getBrandById(brandId);
	}

	public void deleteBrand(Long brandId) {
		brandDao.deleteBrand(brandId);
	}

	public List<EbBrand> selectBrandAll() {
		return brandDao.selectBrandAll();
	}

	public List<EbBrand> selectBrandByName(String brandName) {
		return brandDao.selectBrandByName(brandName);
	}

}
