package com.sf.demo.service.security;

import com.sf.demo.common.page.PageVo;
import com.sf.demo.dto.RoleDto;
import com.sf.demo.dto.RoleQueryDto;
import com.sf.demo.model.Role;
import com.sf.demo.vo.MenuVo;

import java.util.List;
import java.util.Map;

/**
 * @Title: RoleService
 * @Author 殇枫
 * @Package com.sf.demo.service.security
 * @Date 2025/8/7
 * @description:
 */
public interface RoleService {
    PageVo<Role> getRolePage(RoleQueryDto roleQueryDto);

    void addRole(RoleDto roleDto);

    void updateRole(RoleDto roleDto);

    void removeRole(Integer... ids);


    List<MenuVo> getFunList();

    List<Integer> getRoleFunIdList(Integer roleId);

    void updateRoleFun(Map<String, Object> map);
}
