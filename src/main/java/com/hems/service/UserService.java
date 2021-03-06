package com.hems.service;

import com.hems.models.User;

public interface UserService {

    /**
     * Finds user by username.
     *
     * @param username
     * @return user
     */
    User findByUsername(String username);
}
