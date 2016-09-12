package com.wx.pro.model.dao;

import org.springframework.stereotype.Repository;

import com.wx.pro.common.entity.Specification;

@Repository
public interface SpecificationMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}