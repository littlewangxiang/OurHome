package com.wx.pro.model.dao;

import com.wx.pro.common.entity.InsterestThingDiscuss;

public interface InsterestThingDiscussMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(InsterestThingDiscuss record);

    int insertSelective(InsterestThingDiscuss record);

    InsterestThingDiscuss selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(InsterestThingDiscuss record);

    int updateByPrimaryKey(InsterestThingDiscuss record);
}