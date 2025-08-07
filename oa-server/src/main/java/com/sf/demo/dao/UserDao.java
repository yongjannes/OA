package com.sf.demo.dao;

import com.sf.demo.dto.UserDto;
import com.sf.demo.dto.UserQueryDto;
import com.sf.demo.model.Role;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Title: UserDao
 * @Author 殇枫
 * @Package com.sf.demo.dao
 * @Date 2025/8/7
 * @description:
 */
@Mapper
public interface UserDao {

    List<User> findUserList(UserQueryDto userQueryDto);

    //自动生成用户账号格式：U00001、U00002
    @Select("select ifnull(max(convert(substr(u_id,2),unsigned)),0) from t_user where instr(u_id,'U') = 1")
    int findMaxId();

    @Insert("insert into t_user(u_id,u_name,u_pwd) values(#{u_id},#{u_name},'123456')")
    void insertUser(UserDto userDto);

    @Update("update t_user set u_name = #{u_name} where u_id = #{u_id}")
    void updateUser(UserDto userDto);

    void deleteUser(@Param("ids") String[] ids);


    List<Role> findAllRoleList();

    @Select("select ro_id from t_ur where  u_id = #{userId}")
    List<Integer> findUserRoleIdList(String userId);

    @Delete("delete from t_ur where u_id = #{userId}")
    void deleteUserRole(Map<String, Object> map);

    void insertUserRole(Map<String, Object> map);

    boolean findExistsRoles(@Param("userIds") String... ids);


    List<String> findAllNotNormalUsers();
}