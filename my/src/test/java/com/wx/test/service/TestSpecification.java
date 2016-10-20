package com.wx.test.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.bean.SpecificationBean;
import com.wx.pro.common.entity.Specification;
import com.wx.pro.model.service.ISpecificationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestSpecification {

	@Autowired
	private ISpecificationService specService;
	
	@Test
	public void testGetAll(){
		List<Specification> specList = specService.getAllSpec();
		System.out.println(specList.size());
	}
	@Test
	public void testGetById(){
		Specification spec = specService.getSpecById(1);
		System.out.println(spec.getName());
	}
	@Test
	public void testAddAndId(){
		SpecificationBean specBean =new SpecificationBean();
		specBean.setName("测试项目");
		Specification spec = specService.addSpec(specBean);
		System.out.println(spec.getName());
	}
}



