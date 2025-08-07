package com.sf.demo.service.security.impl;

import com.sf.demo.common.ex.BusinessException;
import com.sf.demo.common.page.PageVo;
import com.sf.demo.dao.UserDao;
import com.sf.demo.dto.UserDto;
import com.sf.demo.dto.UserQueryDto;
import com.sf.demo.model.Role;
import com.sf.demo.service.security.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Title: UserServiceImpl
 * @Author 殇枫
 * @Package com.sf.demo.service.security.impl
 * @Date 2025/8/7
 * @description:
 */
@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public PageVo<User> getUserPage(UserQueryDto userQueryDto) {



        return PageVo.getPageVo(userQueryDto,()-> userDao.findUserList(userQueryDto));
    }


    private int id;//最大编号

    @PostConstruct //（初始化方法）表示该方法在创建对象后执行，而仅执行一次
    public void init(){
        id = userDao.findMaxId();
    }

    private synchronized String newId(){
        return String.format("U%05d",++id);
    }

    @Override
    public void addUser(UserDto userDto) {
        userDto.setU_id(newId());
        userDao.insertUser(userDto);
    }

    @Override
    public void updateUser(UserDto userDto) {
        userDao.updateUser(userDto);
    }

    @Override
    public void removeUser(String... ids) {
        if(ids == null || ids.length == 0){
            throw new BusinessException("请选择至少一条数据！");
        }

        List<String> userIdList = userDao.findAllNotNormalUsers();
        boolean has = Arrays.stream(ids).anyMatch(id->{
            return userIdList.stream().anyMatch(userId -> userId.equals(id));
        });

        if(has){
            throw new BusinessException("将要删除的用户中至少有一个用户非普通用户，不允许删除！");
        }

        if(userDao.findExistsRoles(ids)){
            throw new BusinessException("将要删除的用户中至少有一个用户已分配角色，不允许删除！");
        }
        userDao.deleteUser(ids);
    }

    @Override
    public List<Role> getRoleList() {
        return userDao.findAllRoleList();
    }

    @Override
    public List<Integer> getUserRoleIdList(String userId) {
        return userDao.findUserRoleIdList(userId);
    }

    @Override
    public void updateUserRole(Map<String, Object> map) {
        //先删除指定角色下的权限
        userDao.deleteUserRole(map);

        List<Integer> roleIds = (List<Integer>)map.get("roleIds");
        if(roleIds != null && roleIds.size() > 0) {
            //再将提交的权限新增
            userDao.insertUserRole(map);
        }
    }

}
