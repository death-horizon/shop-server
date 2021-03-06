package com.death.horizon.shopserver.config;

import com.death.horizon.shopserver.handler.LogInterceptor;
import com.death.horizon.shopserver.handler.LoginCheckInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dayday
 */
@SpringBootConfiguration
public class WebAppInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录验证拦截器
        registry.addInterceptor(getLoginCheckInterceptor())
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/register", "/api/check-username-exist")
                .excludePathPatterns("/**/*.html", "/**/*.js", "/**/*.png",
                        "/**/*.css", "/**/*.woff", "/**/*.woff2");

        //请求记录日志拦截器
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**", "/swagger*/**",
                        "/**/*.html", "/**/*.js", "/**/*.png", "/**/*.css",
                        "/**/*.woff", "/**/*.woff2");
    }

    @Bean
    public LoginCheckInterceptor getLoginCheckInterceptor() {
        return new LoginCheckInterceptor();
    }
}
