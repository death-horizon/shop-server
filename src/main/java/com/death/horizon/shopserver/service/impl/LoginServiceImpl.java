package com.death.horizon.shopserver.service.impl;

import com.death.horizon.shopserver.dao.LoginDao;
import com.death.horizon.shopserver.model.User;
import com.death.horizon.shopserver.model.login.request.LoginRequest;
import com.death.horizon.shopserver.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author dayday
 */
@Service
public class LoginServiceImpl implements LoginService {


    private final LoginDao loginDao;

    @Autowired
    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public User getUser(LoginRequest loginRequest) {
        User user = new User(loginRequest);
        return loginDao.getUser(user);
    }

    @Override
    public User register(LoginRequest loginRequest) {
        User user = new User(loginRequest);
        if (loginDao.insertUser(user) > 0) {
            return user;
        }
        return null;
    }

    @Override
    public boolean hasUsername(String username) {
        return loginDao.hasUsername(username);
    }

}
