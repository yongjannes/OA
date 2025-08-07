package com.sf.demo.service.security;

import com.sf.demo.common.currentuser.CurrentUser;

import java.util.Map;

/**
 * @Title: LoginService
 * @Author 殇枫
 * @Package com.sf.demo.service.security
 * @Date 2025/8/7
 * @description:
 */
public interface LoginService {
    CurrentUser checkLogin(Map<String, String> loginDto);
}
