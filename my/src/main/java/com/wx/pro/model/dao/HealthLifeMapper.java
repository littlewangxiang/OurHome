package com.wx.pro.model.dao;

import org.springframework.stereotype.Repository;

import com.wx.pro.common.entity.HealthLife;

@Repository
public interface HealthLifeMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(HealthLife record);

    int insertSelective(HealthLife record);

    HealthLife selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(HealthLife record);

    int updateByPrimaryKey(HealthLife record);
}