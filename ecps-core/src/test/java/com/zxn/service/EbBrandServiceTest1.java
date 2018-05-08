package com.zxn.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//使用spring提供的测试类来测试。省去了单独配置ApplicationContext的麻烦
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class EbBrandServiceTest1 {
	@Autowired
	//不用getbean了
	EbBrandService ebBrandService;

	@Test
	public void testSaveBrand() {
		System.out.println(ebBrandService);
	}
	

	@Test
	public void testUpdateBrand() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBrandById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteBrand() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectBrandAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectBrandByName() {
		fail("Not yet implemented");
	}

}
