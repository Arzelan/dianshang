package com.zxn.service;

import java.util.Map;

import com.zxn.util.Page;

public interface EbItemService {
	
	public Page selectItemByCondition(Map<String, Object> map);

}
