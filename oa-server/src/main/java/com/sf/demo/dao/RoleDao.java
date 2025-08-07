package com.sf.demo.dao;

import com.sf.demo.dto.RoleDto;
import com.sf.demo.dto.RoleQueryDto;
import com.sf.demo.model.Role;
import com.sf.demo.vo.MenuVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Title: RoleDao
 * @Author 殇枫
 * @Package com.sf.demo.dao
 * @Date 2025/8/7
 * @description:
 */
@Mapper
public interface RoleDao {

    List<Role> findRoleList(RoleQueryDto roleQueryDto);

    @Select("select ifnull(max(ro_id),0) from t_role")
    int findMaxId();

    @Insert("insert into t_role(ro_id,ro_name) values(#{ro_id},#{ro_name})")
    void insertRole(RoleDto roleDto);

    @Update("update t_role set ro_name = #{ro_name} where ro_id = #{ro_id}")
    void updateRole(RoleDto roleDto);

    void deleteRole(@Param("ids") Integer[] ids);


    List<MenuVo> findAllFunList();

    @Select("select f_id from t_rf where  ro_id = #{roleId}")
    List<Integer> findRoleFunIdList(Integer roleId);

    @Delete("delete from t_rf where ro_id = #{roleId}")
    void deleteRoleFun(Map<String, Object> map);

    void insertRoleFun(Map<String, Object> map);

    boolean findExistsUser(@Param("roleIds") Integer[] ids);

    boolean findExistsFun(@Param("roleIds") Integer[] ids);
}