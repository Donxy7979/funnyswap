package com.funnyswap.service;

import com.funnyswap.domain.Item;

import java.util.List;


public interface ItemService {
     List<Item> getItem(Item item);
     int addItem(Item item);
     void editItem(Item item);
}
