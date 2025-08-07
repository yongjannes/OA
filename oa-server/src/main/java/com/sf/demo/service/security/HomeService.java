package com.sf.demo.service.security;

import com.sf.demo.common.currentuser.CurrentUser;
import com.sf.demo.vo.MenuVo;

import java.util.List;
import java.util.Map;

/**
 * @Title: HomeService
 * @Author 殇枫
 * @Package com.sf.demo.service.security
 * @Date 2025/8/7
 * @description:
 */
public interface HomeService {
    List<MenuVo> getMenuList(CurrentUser currentUser);

    void updatePassword(Map<String, String> pwdDto);
}
