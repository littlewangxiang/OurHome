package com.wx.test.dao;

import java.util.Date;
import java.util.List;

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
		spec.setName("缴费项目");
		specificationDao.insert(spec);
	}
	@Test
	public void testAddSel(){
		Specification spec = new Specification();
		spec.setAddDate(new Date());
		spec.setDeleteStatus(1);
		spec.setLastModifyDate(new Date());
		spec.setName("缴费项目1");
		specificationDao.insertSelective(spec);
		System.out.println(spec.getuId());
	}
	
	@Test
	public void testGetAll(){
		List<Specification> list = specificationDao.getAllSpec();
		System.out.println(list.size());
	}
	@Test
	public void delById(){
		specificationDao.deleteByPrimaryKey(1);
	}
	@Test
	public void selectByPrimaryKey(){
		Specification spec = specificationDao.selectByPrimaryKey(1);
		System.out.println(spec.getName());
	}
	
	@Test
	public void updateByPrimaryKeySelective(){
		Specification spec = specificationDao.selectByPrimaryKey(1);
		spec.setLastModifyDate(new Date());
		spec.setName("卖菜外");
		specificationDao.updateByPrimaryKeySelective(spec);
	}
	@Test
	public void updateByPrimaryKey(){
		Specification spec = specificationDao.selectByPrimaryKey(1);
		spec.setLastModifyDate(new Date());
		spec.setName("卖菜外1");
		specificationDao.updateByPrimaryKey(spec);
	}
	
}
