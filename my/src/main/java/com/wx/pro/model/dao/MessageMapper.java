package com.wx.pro.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wx.pro.common.entity.Message;
@Repository
public interface MessageMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
    
    List<Message> getListMsgByUserId(Integer userId);
}