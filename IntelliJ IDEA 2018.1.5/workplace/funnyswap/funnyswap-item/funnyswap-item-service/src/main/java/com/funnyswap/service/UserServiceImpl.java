package com.funnyswap.service;

import com.funnyswap.dao.UserDao;
import com.funnyswap.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    public List<User> getUser(User user){
       return userDao.selectUser(user);

    }

    public Integer regUser(User user){
        return userDao.insertUser(user);
    }
    public void editUser(User user){
        userDao.updateUser(user);
    }
}
