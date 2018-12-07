package com.funnyswap.service;

import com.funnyswap.dao.ItemDao;
import com.funnyswap.domain.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    ItemDao itemDao;
    @Override
    public List<Item> getItem(Item item) {
        return itemDao.selectItem(item);
    }
    @Override
    public int addItem (Item item){
        return itemDao.insertItem(item);
    }
    @Override
    public void editItem(Item item){
        itemDao.updateItem(item);
    }
}
