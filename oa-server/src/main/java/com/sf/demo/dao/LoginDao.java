package com.sf.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Title: LoginDao
 * @Author 殇枫
 * @Package com.sf.demo.dao
 * @Date 2025/8/7
 * @description:
 */
@Mapper
public interface LoginDao {

    @Select("select u_id,u_name from t_user where u_id = #{u_id} and u_pwd = #{u_pwd}")
    Map<String, String> findUserByUserIdAndUserPwd(Map<String, String> loginDto);
}