package com.funnyswap.controller;

import com.funnyswap.common.builder.ResponseBuilder;
import com.funnyswap.common.utils.ItemIdUtil;
import com.funnyswap.domain.Item;
import com.funnyswap.dto.input.AddItemRequestInput;
import com.funnyswap.dto.input.DeleteItemRequestInput;
import com.funnyswap.dto.input.EditItemRequestInput;
import com.funnyswap.dto.input.QueryItemRequestInput;
import com.funnyswap.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.funnyswap.common.utils.Response;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Resource
    ItemService itemService;

    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public Response queryItem(@RequestBody QueryItemRequestInput input) {
        Item item = new Item();
        item.setItemId(input.getItemId());
        item.setDepreciation(input.getDepreciation());
        item.setMemberId(input.getMemberId());
        item.setName(input.getName());
        item.setProperty(input.getProperty());
        item.setCategory(input.getCategory());
        item.setEvaluation(input.getEvaluation());
        return ResponseBuilder.buildSuccess(itemService.getItem(item));
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public Response editItem(@RequestBody EditItemRequestInput input) {
        Item item = new Item();
        item.setItemId(input.getItemId());
        item.setName(input.getName());
        item.setDepreciation(input.getDepreciation());
        item.setCategory(input.getCategory());
        item.setProperty(input.getProperty());
        item.setEvaluation(input.getEvaluation());
        item.setPicture(input.getPicture());
        item.setRemark(input.getRemark());
        itemService.editItem(item);
        return ResponseBuilder.buildSuccess(item.getItemId() + "更新成功");
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Response addItem(@RequestBody AddItemRequestInput input) {
        Item item = new Item();
        item.setItemId(ItemIdUtil.getNewItemId());
        item.setName(input.getName());
        item.setMemberId(input.getMemberId());
        item.setDepreciation(input.getDepreciation());
        item.setCategory(input.getCategory());
        item.setProperty(input.getProperty());
        item.setEvaluation(input.getEvaluation());
        item.setPicture(input.getPicture());
        item.setRemark(input.getRemark());
        itemService.addItem(item);
        return ResponseBuilder.buildSuccess(item.getItemId() + "添加成功");
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteItem(@RequestBody DeleteItemRequestInput input) {
        Item item = new Item();
        item.setItemId(input.getItemId());
        item.setDelFlag(1);
        itemService.editItem(item);
        return ResponseBuilder.buildSuccess(item.getItemId() + "删除成功");

    }

}
