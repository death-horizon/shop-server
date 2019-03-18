package com.death.horizon.shopserver.handler;

import com.death.horizon.shopserver.config.LoginSession;
import com.death.horizon.shopserver.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author dayday
 */
@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String header = request.getHeader("access-token");
        if (header == null) {
            // 测试短信登录
            // Result.fail("登录验证失败请重新登录");
            return false;
        }
        User user = LoginSession.getUserByToken(header);
        if (user == null) {
            // Result.fail("登录验证失败请重新登录");
            return false;
        }
        ThreadLocalUser.setUser(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) {
        ThreadLocalUser.remove();
    }
}
