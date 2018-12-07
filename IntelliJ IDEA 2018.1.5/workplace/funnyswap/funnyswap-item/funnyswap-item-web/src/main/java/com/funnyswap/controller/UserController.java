package com.funnyswap.controller;


import com.funnyswap.common.builder.ResponseBuilder;
import com.funnyswap.common.enums.ExceptionEnum;
import com.funnyswap.common.excption.FsException;
import com.funnyswap.common.utils.MemberIdUtil;
import com.funnyswap.common.utils.Response;
import com.funnyswap.domain.User;
import com.funnyswap.dto.input.DeleteUserRequestInput;
import com.funnyswap.dto.input.EditUserRequestInput;
import com.funnyswap.dto.input.LoginRequestInput;
import com.funnyswap.dto.input.QueryUserRequestInput;
import com.funnyswap.dto.input.RegUserRequestInput;
import com.funnyswap.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;


    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public Response queryUser(@RequestBody QueryUserRequestInput input) {
        try {
            User user = new User();
            user.setMemberId(input.getMemberId());
            user.setMemberEmail(input.getMemberEmail());
            user.setMemberPhone(input.getMemberPhone());
            return ResponseBuilder.buildSuccess(userService.getUser(user));
        } catch (Exception e) {
            return ResponseBuilder.buildSuccess(e.getMessage());
        }
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public Response editUser(@RequestBody EditUserRequestInput input) {
        try {
            User user = new User();
            user.setMemberId(input.getMemberId());
            user.setMemberAccount(input.getMemberAccount());
            user.setMemberPassword(input.getMemberPassword());
            user.setMemberPhone(input.getMemberPhone());
            user.setMemberEmail(input.getMemberEmail());
            userService.editUser(user);
            return ResponseBuilder.buildSuccess(user.getMemberId() + "修改成功");
        } catch (Exception e) {
            return ResponseBuilder.buildSuccess(e.getMessage());
        }
    }

    @RequestMapping(value = "reg", method = RequestMethod.POST)
    @ResponseBody
    public Response regUser(@RequestBody RegUserRequestInput input) {
        User user = new User();
        user.setMemberAccount(input.getMemberAccount());
        if (!(CollectionUtils.isEmpty(userService.getUser(user))))
            throw new FsException(ExceptionEnum.REG_ACCOUNT_REPEAT);
        user.setMemberId(MemberIdUtil.getNewMemberId());
        user.setMemberPassword(input.getMemberPassword());
        user.setMemberPhone(input.getMemberPhone());
        user.setMemberEmail(input.getMemberEmail());
        userService.regUser(user);
        return ResponseBuilder.buildSuccess(user.getMemberId() + "注册成功");
    }


    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteUser(@RequestBody DeleteUserRequestInput input) {
        User user = new User();
        user.setMemberId(input.getMemberId());
        user.setDelFlag(1);
        userService.editUser(user);
        return ResponseBuilder.buildSuccess(user.getMemberId() + "删除成功");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestBody LoginRequestInput input) {
        User user = new User();
        user.setMemberAccount(input.getMemberAccount());
        user.setMemberPassword(input.getMemberPassword());
        if (CollectionUtils.isEmpty(userService.getUser(user))) {
            throw new FsException(ExceptionEnum.LOGIN_FAIL);
        }
        return ResponseBuilder.buildSuccess(userService.getUser(user).get(0));
    }
}
