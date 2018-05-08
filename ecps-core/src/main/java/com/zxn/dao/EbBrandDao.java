package com.zxn.dao;

import java.util.List;

import com.zxn.model.EbBrand;

public interface EbBrandDao {
	
	public void saveBrand(EbBrand brand);
	
	public void updateBrand(EbBrand brand);
	
	public EbBrand getBrandById(Long brandId);
	
	public void deleteBrand(Long brandId);
	
	public List<EbBrand> selectBrandAll();
	
	public List<EbBrand> selectBrandByName(String brandName);

}
