package com.sf.demo.api;

import com.sf.demo.common.verifycode.VerifyCodeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.OutputStream;

/**
 * @Title: VerifyCodeController
 * @Author 殇枫
 * @Package com.sf.demo.api
 * @Date 2025/8/7
 * @description:
 */
@RestController
public class VerifyCodeController {

    @GetMapping("/res/verifycode")
    public void outVerifyCodeImage(String u_verify_key, OutputStream out){
        VerifyCodeUtils.outVerifyCodeImage(u_verify_key,out);
    }
}