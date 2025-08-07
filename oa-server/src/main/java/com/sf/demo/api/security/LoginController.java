package com.sf.demo.api.security;

import com.sf.demo.common.currentuser.CurrentUser;
import com.sf.demo.common.token.TokenUser;
import com.sf.demo.common.token.TokenUtils;
import com.sf.demo.common.verifycode.VerifyCodeUtils;
import com.sf.demo.common.vo.R;
import com.sf.demo.service.security.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Title: LoginController
 * @Author 殇枫
 * @Package com.sf.demo.api.security
 * @Date 2025/8/7
 * @description:
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/security/login")
public class LoginController {

    private final LoginService loginService;
    private final TokenUtils tokenUtils;
    private final HttpServletRequest request;

    @PostMapping("")
    public R<?> login(@RequestBody Map<String,String> loginDto){

        if(!VerifyCodeUtils.checkVerifyCode(
                loginDto.get("u_verify_key"),loginDto.get("u_verify_code"))){
            return R.err(R.CODE_ERR_BUSI,"验证码错误！");
        }

        CurrentUser currentUser = loginService.checkLogin(loginDto);
        String userIp = request.getRemoteAddr();
        TokenUser tokenUser = new TokenUser(
                currentUser.getUserId(), currentUser.getUserName(), userIp);

        String token = tokenUtils.loginSign(tokenUser, loginDto.get("u_pwd"));
        return R.OK(token);
    }
}