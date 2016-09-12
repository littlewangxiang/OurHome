package com.wx.pro.model.dao;

import com.wx.pro.common.entity.LivingPayment;

public interface LivingPaymentMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(LivingPayment record);

    int insertSelective(LivingPayment record);

    LivingPayment selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(LivingPayment record);

    int updateByPrimaryKey(LivingPayment record);
}