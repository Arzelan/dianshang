package com.zxn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxn.service.EbFeatureService;

@Controller
@RequestMapping("/feature")
public class EbFeatureController {
	@Autowired
	EbFeatureService featureService;
	
	@RequestMapping("selectFeatureAll.do")
	public String selectFeatureAll(Model model){
		model.addAttribute("fList", featureService.selectFeatureAll());
		return "item/listfeature";
	}
}
