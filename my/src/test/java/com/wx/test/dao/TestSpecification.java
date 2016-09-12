package com.wx.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.entity.Specification;
import com.wx.pro.model.dao.SpecificationMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestSpecification {
	@Autowired
	private SpecificationMapper specificationDao;
	
	@Test
	public void testAdd(){
		Specification spec = new Specification();
		spec.setAddDate(new Date());
		spec.setDeleteStatus(1);
		spec.setLastModifyDate(new Date());
		spec.setName("Âò²Ë");
		specificationDao.insert(spec);
	}
	
}
