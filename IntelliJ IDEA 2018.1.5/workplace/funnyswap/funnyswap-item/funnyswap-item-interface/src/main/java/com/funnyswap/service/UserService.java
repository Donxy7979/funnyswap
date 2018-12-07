package com.funnyswap.service;

import com.funnyswap.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUser(User user);
    Integer regUser(User user);
    void editUser(User user);
}
