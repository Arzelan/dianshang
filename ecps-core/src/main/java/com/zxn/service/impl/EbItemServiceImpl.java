package com.zxn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxn.dao.EbItemDao;
import com.zxn.model.EbItem;
import com.zxn.service.EbItemService;
import com.zxn.util.Page;
@Service
public class EbItemServiceImpl implements EbItemService {
	
	@Autowired
	EbItemDao itemDao;
	/**
	 * map.put("brandId" 1003);
	  	map.put("auditStatus", 1);
	  	map.put("itemName", "S4");
	  	map.put("pageNo", 5);
	  	
	 */
	public Page selectItemByCondition(Map<String, Object> map) {
		//获得当前页码
		Integer pageNo = (Integer) map.get("pageNo");
		//获得当前查询条件下总记录数
		Integer totalCount = itemDao.selectItemByConditionCount(map);
		//创建页面对象
		Page page = new Page();
		//设置当前条件总记录数
		page.setTotalCount(totalCount);
		//设置当前页码
		page.setPageNo(pageNo);
		//计算获得开始和结束的行号
		Integer startNum = page.getStartNum();
		Integer endNum = page.getEndNum();
		//把开始和结束的行号放到参数集合中
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		//查询结果集数据
		List<EbItem> itemList = itemDao.selectItemByCondition(map);
		//把结果集放入Page对象
		page.setList(itemList);
		return page;
	}

}
