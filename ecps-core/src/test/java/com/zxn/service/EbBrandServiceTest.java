package com.zxn.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zxn.model.EbBrand;

public class EbBrandServiceTest {
	ApplicationContext ctx;
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
	}

	@Test
	public void testSaveBrand() {
		EbBrandService bs =  (EbBrandService) ctx.getBean("ebBrandServiceImpl");
		System.out.println(bs);
		EbBrand eb = new EbBrand();
		eb.setBrandName("锤子");
		eb.setBrandDesc("老罗");
		eb.setWebsite("www.laoluo.com");
		eb.setBrandSort(1);
		eb.setImgs("jjj");
		bs.saveBrand(eb);
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
