package com.zxn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxn.model.EbBrand;
import com.zxn.model.EbFeature;
import com.zxn.service.EbBrandService;
import com.zxn.service.EbFeatureService;
import com.zxn.service.EbItemService;
import com.zxn.util.Page;

@Controller
@RequestMapping("/item")
public class EbItemController {
	@Autowired
	EbBrandService brandService;
	
	@Autowired
	EbItemService itemService;
	
	@Autowired
	EbFeatureService featureService;
	
	@RequestMapping("/toItemIndex.do")
	public String selectBrandAll() {
		return "item/index";	
	}
	
	@RequestMapping("/selectItemByCondition.do")
	public String selectItemByCondition(Model model, Long brandId,
			Integer auditStatus, Integer showStatus, String itemName, Integer pageNo){
		//查询所有品牌
		List<EbBrand> bList = brandService.selectBrandAll();
		model.addAttribute("bList", bList);
		//pageNo判空
		if(pageNo == null){
			pageNo = 1;
		}
		//定义参数集合，并且把参数放入集合之中
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandId", brandId);
		map.put("auditStatus", auditStatus);
		map.put("showStatus", showStatus);
		map.put("itemName", itemName);
		map.put("pageNo", pageNo);
		//查询结果集
		Page page = itemService.selectItemByCondition(map);
		//把结果写回页面，并且把查询条件回显
		model.addAttribute("page", page);
		model.addAttribute("brandId", brandId);
		model.addAttribute("auditStatus", auditStatus);
		model.addAttribute("showStatus", showStatus);
		model.addAttribute("itemName", itemName);
		return "item/list";
	}
	@RequestMapping("toAddItem.do")
	public String toAddItem(Model model) {
		//查询所有品牌
		List<EbBrand> bList = brandService.selectBrandAll();
		model.addAttribute("bList", bList);
		List<EbFeature> paraList = featureService.selectnoSpecFeature();
		model.addAttribute("paraList", paraList);
		List<EbFeature> specList = featureService.selectIsSpecFeature();
		model.addAttribute("specList", specList);
		return "item/addItem";
	}
	
	
}
