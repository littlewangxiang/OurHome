package com.wx.pro.model.dao;

import org.springframework.stereotype.Repository;

import com.wx.pro.common.entity.User;

@Repository
public interface UserMapper {
	
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}