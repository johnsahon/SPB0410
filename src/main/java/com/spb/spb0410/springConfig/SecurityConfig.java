package com.spb.spb0410.springConfig;

import com.spb.spb0410.filter.AjaxTimeoutRedirectFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.sql.DataSource;


// 搭配SecurityWebInitializer建立，作為安全組態檔案
@Configuration
@EnableWebSecurity // 在web應用中是基於filter的，啟用Spring Security所需的各項配置，本身是一個＠Configuration的多組合配置
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public SecurityConfig(DataSource dataSource) {
    }

    // http security配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().sameOrigin();
        http.addFilterBefore(new AjaxTimeoutRedirectFilter(), FilterSecurityInterceptor.class);
        http.authorizeRequests().antMatchers("/resources/**").permitAll();
         // 後端產生的csrf token ，這裡收，沒token就不過，先註解
		//		http.csrf().disable();
       
        http.csrf().ignoringAntMatchers("/index", "/");
    }
}