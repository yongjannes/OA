package com.sf.demo.dao;

import com.sf.demo.common.currentuser.CurrentUser;
import com.sf.demo.vo.MenuVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @Title: HomeDao
 * @Author 殇枫
 * @Package com.sf.demo.dao
 * @Date 2025/8/7
 * @description:
 */
@Mapper
public interface HomeDao {
    List<MenuVo> findMenuList(CurrentUser currentUser);

    @Select("select u_pwd from t_user where u_id = #{userId}")
    String findFactOldPwd(Map<String, String> pwdDto);

    @Update("update t_user set u_pwd = #{new_pwd} where u_id = #{userId}")
    void updatePassword(Map<String, String> pwdDto);
}
