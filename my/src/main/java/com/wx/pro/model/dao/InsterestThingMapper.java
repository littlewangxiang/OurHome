package com.wx.pro.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wx.pro.common.entity.InsterestThing;

@Repository
public interface InsterestThingMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(InsterestThing record);

    int insertSelective(InsterestThing record);

    InsterestThing selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(InsterestThing record);

    int updateByPrimaryKey(InsterestThing record);
    
    List<InsterestThing> selectAll();
}