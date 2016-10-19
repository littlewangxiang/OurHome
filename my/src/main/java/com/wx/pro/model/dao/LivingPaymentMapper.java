package com.wx.pro.model.dao;

import java.util.List;

import com.wx.pro.common.entity.LivingPayment;

public interface LivingPaymentMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(LivingPayment record);

    int insertSelective(LivingPayment record);

    LivingPayment selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(LivingPayment record);

    int updateByPrimaryKey(LivingPayment record);
    
    List<LivingPayment> selectAll();
    
    List<LivingPayment> selectByParam(LivingPayment record);
    
}


