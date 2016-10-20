package com.wx.test.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.entity.LivingPayment;
import com.wx.pro.common.entity.Specification;
import com.wx.pro.common.entity.User;
import com.wx.pro.model.dao.LivingPaymentMapper;
import com.wx.pro.model.dao.SpecificationMapper;
import com.wx.pro.model.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestLivingPayment {

	@Autowired
	private LivingPaymentMapper livePayDao;
	@Autowired
	private UserMapper userDao;
	@Autowired
	private SpecificationMapper sepcDao;

	@Test
	public void testAdd() {
		LivingPayment livePay = new LivingPayment();
		livePay.setAddDate(new Date());
		livePay.setDeleteStatus(1);
		livePay.setLastModifyDate(new Date());
		livePay.setName("16-9-12买菜");
		livePay.setShareInfo("{[user_id: 1,user_name: '笑话',share_status: 1,share_time: 2016-8-1512: 34: 12],[user_id: 2,user_name: '呵呵',share_status: 1,share_time: 2016-8-1512: 34: 12]}");
		livePay.setSpecId(new Specification());
		livePay.setUserId(userDao.selectByPrimaryKey(1));

		livePayDao.insert(livePay);
	}
	@Test
	public void testAddSelecttive(){
		LivingPayment livePay = new LivingPayment();
		livePay.setAddDate(new Date());
		livePay.setDeleteStatus(1);
		livePay.setLastModifyDate(new Date());
		livePay.setName("16-9-12买菜");
		livePay.setShareInfo("{[user_id: 1,user_name: '笑话',share_status: 1,share_time: 2016-8-1512: 34: 12],[user_id: 2,user_name: '呵呵',share_status: 1,share_time: 2016-8-1512: 34: 12]}");
		livePay.setSpecId(sepcDao.selectByPrimaryKey(1));
		livePay.setUserId(userDao.selectByPrimaryKey(2));

		livePayDao.insertSelective(livePay);
	}

	@Test
	public void testDel() {
		livePayDao.deleteByPrimaryKey(1);
	}

	@Test
	public void testSelectById() {
		LivingPayment live = livePayDao.selectByPrimaryKey(1);
		System.out.println(live.getName());
	}
	@Test
	public void testSelectAll(){
		List<LivingPayment> list = livePayDao.selectAll();
		System.out.println(list.size());
	}
	@Test
	public void testSelectByparam(){
		LivingPayment record = new LivingPayment();
		record.setName("16-9-12卖菜分摊");
		List<LivingPayment> list = livePayDao.selectByParam(record);
		System.out.println(list.size());
	}
	@Test
	public void testUpdate(){
		LivingPayment record = null;
		record = livePayDao.selectByPrimaryKey(1);
		record.setLastModifyDate(new Date());
		int a = livePayDao.updateByPrimaryKeySelective(record);
	}
	
}
