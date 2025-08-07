package com.sf.demo.service.security.impl;

import com.sf.demo.common.currentuser.CurrentUser;
import com.sf.demo.common.ex.BusinessException;
import com.sf.demo.dao.LoginDao;
import com.sf.demo.service.security.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @Title: LoginServiceimpl
 * @Author 殇枫
 * @Package com.sf.demo.service.security.impl
 * @Date 2025/8/7
 * @description:
 */
@Service
@Transactional
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao;
    @Override
    public CurrentUser checkLogin(Map<String, String> loginDto) {

        Map<String,String> user = loginDao.findUserByUserIdAndUserPwd(loginDto);
        if(user == null){
            throw new BusinessException("账号或密码错误！");
        }
        CurrentUser currentUser = new CurrentUser(user.get("u_id"), user.get("u_name"));
        return currentUser;
    }
}
