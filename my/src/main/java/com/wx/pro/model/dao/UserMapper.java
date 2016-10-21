package com.wx.pro.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wx.pro.common.entity.User;

@Repository
public interface UserMapper {
	
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);
    /**
	 * 查询用户
	 * 只能根据用户名、邮箱和手机查询
	 * @param userBean
	 * @return
	 */
    List<User> selectByParam(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}