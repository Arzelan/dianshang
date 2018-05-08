package com.zxn.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxn.model.EbBrand;
import com.zxn.service.EbBrandService;

@Controller
@RequestMapping("/brand")
public class EbBrandController {
	
	@Autowired
	EbBrandService brandService;
	
	@RequestMapping("/selectBrandAll.do")
	public String selectBrandAll(Model model) {
		List<EbBrand> bList =  brandService.selectBrandAll();
		model.addAttribute("bList", bList);
		return "item/listbrand";	
	}
	
	@RequestMapping("/toAddBrand.do")
	public String toAddBrand(Model model) {
		return "item/addbrand";	
	}
	
	@RequestMapping("/selectBrandByName.do")
	public void  selectBrandByName(String brandName, PrintWriter out){
		List<EbBrand> list = brandService.selectBrandByName(brandName);
		String tip = "no";
		if(list.size() > 0){
			tip = "yes";
		}
		out.write(tip);
	}
	@RequestMapping("/addBrand.do")
	public String addBrand(EbBrand brand){
		brandService.saveBrand(brand);
		return "redirect:selectBrandAll.do";
	}
	@RequestMapping("/toUpdateBrand.do")
	public String toUpdateBrand(Long brandId, Model model){
		EbBrand brand = brandService.getBrandById(brandId);
		model.addAttribute("brand", brand);
		return "item/editbrand";
	}
	
	@RequestMapping("/updateBrand.do")
	public String updateBrand(EbBrand brand){
		brandService.updateBrand(brand);
		return "redirect:selectBrandAll.do";
	}
	@RequestMapping("/deleteBrand.do")
	public String deleteBrand(Long brandId){
		brandService.deleteBrand(brandId);
		return "redirect:selectBrandAll.do";
	}
}
