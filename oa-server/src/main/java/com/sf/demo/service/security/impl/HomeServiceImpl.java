package com.sf.demo.service.security.impl;

import com.sf.demo.common.currentuser.CurrentUser;
import com.sf.demo.common.ex.BusinessException;
import com.sf.demo.dao.HomeDao;
import com.sf.demo.service.security.HomeService;
import com.sf.demo.vo.MenuVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Title: HomeServiceImpl
 * @Author 殇枫
 * @Package com.sf.demo.service.security.impl
 * @Date 2025/8/7
 * @description:
 */
@Service
@Transactional
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeDao homeDao;
    @Override
    public List<MenuVo> getMenuList(CurrentUser currentUser) {
        return homeDao.findMenuList(currentUser);
    }

    @Override
    public void updatePassword(Map<String, String> pwdDto) {
        String factOldPwd = homeDao.findFactOldPwd(pwdDto);
        if(!factOldPwd.equals(pwdDto.get("old_pwd"))){
            throw new BusinessException("原密码错误！");
        }
        homeDao.updatePassword(pwdDto);
    }
}
