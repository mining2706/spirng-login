package com.kaiser.login.service;

import com.kaiser.login.model.User;

public interface UserService {
    public User findUserByEmail(String email);
    public  void saveUser(User user);
}
