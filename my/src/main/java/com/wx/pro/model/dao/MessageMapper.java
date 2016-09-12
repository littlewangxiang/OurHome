package com.wx.pro.model.dao;

import com.wx.pro.common.entity.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}