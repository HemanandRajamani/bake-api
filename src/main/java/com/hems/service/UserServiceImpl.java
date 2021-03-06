package com.hems.service;

import com.hems.models.Role;
import com.hems.models.User;

import javax.enterprise.context.RequestScoped;
import java.util.Collections;

@RequestScoped
public class UserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) {
        String userUsername = "user";

        //generated from password encoder
        String userPassword = "cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=";

        String adminUsername = "admin";

        //generated from password encoder
        String adminPassword = "dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=";

        if (username.equals(userUsername)) {
            return new User(userUsername, userPassword, Collections.singleton(Role.USER));
        } else if (username.equals(adminUsername)) {
            return new User(adminUsername, adminPassword, Collections.singleton(Role.ADMIN));
        } else {
            return null;
        }
    }
}
