package com.death.horizon.shopserver.model;


import com.death.horizon.shopserver.model.login.request.LoginRequest;
import com.death.horizon.shopserver.util.HashUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


/**
 * @author dayday
 */
@Data
public class User {

    @Value("${password-salt}")
    private String passwordSalt;

    private String username;
    private String passwordHash;

    public User() {
    }

    public User(LoginRequest loginRequest) {
        username = loginRequest.getUsername();
        passwordHash = HashUtils.hash(loginRequest.getPassword(), passwordSalt, 32);
    }
}
