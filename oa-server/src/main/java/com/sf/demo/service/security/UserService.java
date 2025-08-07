package com.sf.demo.service.security;

import com.sf.demo.common.page.PageVo;
import com.sf.demo.dto.UserDto;
import com.sf.demo.dto.UserQueryDto;
import com.sf.demo.model.Role;
import org.apache.catalina.User;

import java.util.List;
import java.util.Map;

/**
 * @Title: UserService
 * @Author 殇枫
 * @Package com.sf.demo.service.security
 * @Date 2025/8/7
 * @description:
 */
public interface UserService {
    PageVo<User> getUserPage(UserQueryDto userQueryDto);

    void addUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void removeUser(String... ids);


    List<Role> getRoleList();

    List<Integer> getUserRoleIdList(String userId);

    void updateUserRole(Map<String, Object> map);
}
