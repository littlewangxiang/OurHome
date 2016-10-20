package com.wx.pro.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wx.pro.common.entity.InsterestThingDiscuss;
@Repository
public interface InsterestThingDiscussMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(InsterestThingDiscuss record);

    int insertSelective(InsterestThingDiscuss record);

    InsterestThingDiscuss selectByPrimaryKey(Integer uId);
    
    List<InsterestThingDiscuss> selectByParam(InsterestThingDiscuss record);

    int updateByPrimaryKeySelective(InsterestThingDiscuss record);

    int updateByPrimaryKey(InsterestThingDiscuss record);
}