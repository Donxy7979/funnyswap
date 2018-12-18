package com.funnyswap.controller;

import com.funnyswap.common.builder.ResponseBuilder;
import com.funnyswap.common.utils.OrderIdUtil;
import com.funnyswap.common.utils.Response;
import com.funnyswap.constants.RequestStatus;
import com.funnyswap.domain.Request;
import com.funnyswap.dto.input.SwapAcceptInput;
import com.funnyswap.dto.input.SwapRejctInput;
import com.funnyswap.dto.input.SwapRequestInput;
import com.funnyswap.service.OrderServService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/orderserv")
public class OrderservController {

    @Resource
    OrderServService orderServService;


    @RequestMapping(value = "/swapRequest",method = RequestMethod.POST)
    @ResponseBody
    public Response sendRequest(@RequestBody SwapRequestInput input){
        Request request = new Request();
        request.setOrderId(OrderIdUtil.getNewOrderId());
        request.setItemAId(input.getItemAId());
        request.setMemberAId(input.getMemberAId());
        request.setItemBId(input.getItemBId());
        request.setMemberBId(input.getMemberBId());
        request.setRequestStatus(RequestStatus.COMMIT);
        request.setRemark("申请成功");
        orderServService.sendRequest(request);
        return ResponseBuilder.buildSuccess(request.getOrderId()+"申请成功");
    }

    @RequestMapping(value = "/swapAccept" , method = RequestMethod.POST)
    @ResponseBody
    public Response acceptRequest(@RequestBody SwapAcceptInput input){
        Request request = new Request();
        request.setOrderId(input.getOrderId());
        orderServService.accept(request);
        return ResponseBuilder.buildSuccess("下单成功");
    }

    @RequestMapping(value = "/swapRejct" ,method = RequestMethod.POST)
    @ResponseBody
    public Response rejectRequest(@RequestBody SwapRejctInput input){
        Request request = new Request();
        request.setOrderId(input.getOrderId());
        request.setRequestStatus(RequestStatus.REJECT);
        orderServService.rejectRequest(request);
        return ResponseBuilder.buildSuccess("已拒绝该申请");
    }
}
