package com.death.horizon.shopserver.service;


import com.death.horizon.shopserver.model.User;
import com.death.horizon.shopserver.model.login.request.LoginRequest;

/**
 * @author dayday
 */
public interface LoginService {

    User getUser(LoginRequest loginRequest);

    User register(LoginRequest loginRequest);

    /**
     * 判断用户名是否已经存在
     *
     * @param username 需要判断的用户名
     * @return 存在返回true
     */
    boolean hasUsername(String username);
}
