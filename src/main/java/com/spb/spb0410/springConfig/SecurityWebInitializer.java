package com.spb.spb0410.springConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

// AbstractSecurityWebApplicationInitializer會在應用程式初始化時進行過濾器的建立與設定
public class SecurityWebInitializer  extends AbstractSecurityWebApplicationInitializer  {
    
    //依需求配置你要的東東 
    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");
        super.beforeSpringSecurityFilterChain(servletContext);
    }
}

