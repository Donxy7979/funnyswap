package com.funnyswap.dao;

import com.funnyswap.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ItemDao {
    List<Item> selectItem(Item item);
    int insertItem(Item item);
    void updateItem(Item item);
}
