package com.funnyswap.dao;

import com.funnyswap.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDao {
    List<Order> selectOrder(Order order);

    Integer insertOrder(Order order);

    void updateOrder(Order order);

    List<Order> selectOrderFuzzy(Order order);
}
