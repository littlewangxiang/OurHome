package com.wx.pro.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wx.pro.common.entity.Specification;

@Repository
public interface SpecificationMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(Specification record);
    /**
     * 选择性添加，同时添加完后会返回添加的id
     * @param record
     * @return
     */
    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
    
    List<Specification> getAllSpec();
}