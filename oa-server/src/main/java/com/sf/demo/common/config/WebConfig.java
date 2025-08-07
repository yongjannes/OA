package com.sf.demo.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sf.demo.common.filter.SecurityFilter;
import com.sf.demo.common.token.TokenUtils;

@Configuration
public class WebConfig {


    @Bean
    public FilterRegistrationBean<SecurityFilter> securityFilterFilterRegistrationBean(TokenUtils tokenUtils,AnonUrls anonUrls){
        FilterRegistrationBean<SecurityFilter> securityFilterFilterRegistrationBean =
                new FilterRegistrationBean<>(new SecurityFilter(tokenUtils,anonUrls));
        securityFilterFilterRegistrationBean.addUrlPatterns("/*");
        securityFilterFilterRegistrationBean.setOrder(0);
        return securityFilterFilterRegistrationBean;
    }


}
