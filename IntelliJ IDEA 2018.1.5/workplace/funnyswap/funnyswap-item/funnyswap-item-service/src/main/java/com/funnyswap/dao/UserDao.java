package com.funnyswap.dao;

import com.funnyswap.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserDao {
    List<User> selectUser(User user);
    Integer insertUser(User user);
    void updateUser(User user);

}
