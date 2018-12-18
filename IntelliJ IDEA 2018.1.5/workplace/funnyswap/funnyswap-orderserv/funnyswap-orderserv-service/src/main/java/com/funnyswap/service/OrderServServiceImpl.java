package com.funnyswap.service;

import com.funnyswap.common.enums.ExceptionEnum;
import com.funnyswap.common.excption.FsException;
import com.funnyswap.constants.OrderStatus;
import com.funnyswap.constants.RequestStatus;
import com.funnyswap.dao.OrderDao;
import com.funnyswap.dao.RequestDao;
import com.funnyswap.domain.Order;
import com.funnyswap.domain.Request;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServServiceImpl implements OrderServService {
    @Resource
    RequestDao requestDao;

    @Resource
    OrderDao orderDao;


    public void sendRequest(Request request){
        if (requestCheck(request))
            requestDao.insertRequest(request);
    }

    public void accept(Request input) {
        List<Request> list = requestDao.selectRequest(input);
        if (list.size() != 1)
            throw new FsException(ExceptionEnum.REQUEST_ERROR);
        Request re = list.get(0);
        if (orderCheck(re.getItemAId()) && orderCheck(re.getItemBId())) {
            Request ra = new Request();
            Request rb = new Request();
            ra.setItemAId(re.getItemAId());
            rb.setItemAId(re.getItemBId());
            List<Request> requestList = requestDao.selectRequestFuzzy(ra);
            requestList.addAll(requestDao.selectRequestFuzzy(rb));
            requestList = requestList.stream().filter(request -> !(request.getOrderId().equalsIgnoreCase(input.getOrderId()))).collect(Collectors.toList());
            for (Request request : requestList) {
                request.setRequestStatus(RequestStatus.REJECT);
                request.setRemark("存在已下单物品");
                requestDao.updateRequest(request);

            }
            //调订单接口
            re.setOrderId(input.getOrderId());
            re.setRequestStatus(RequestStatus.ACCEPT);
            re.setRemark("下单成功");
            requestDao.updateRequest(re);
            Order order = new Order(re);
            order.setOrderStatus(OrderStatus.COMMIT);
            order.setRemark("提交成功");
            orderDao.insertOrder(order);
        }
    }

    private boolean requestCheck(Request request) {
        Request re = new Request();
        re.setItemAId(request.getItemAId());
        re.setItemBId(request.getItemBId());
        re.setRequestStatus(RequestStatus.COMMIT);
        if (CollectionUtils.isEmpty(requestDao.selectRequest(re))) {
            orderCheck(re.getItemAId());
            orderCheck(re.getItemBId());
            return true;
        } else
            throw new FsException(ExceptionEnum.REQUEST_REPEAT);
    }

    private boolean orderCheck(String itemId) {
        Order order = new Order();
        order.setItemAId(itemId);
        List<Order> orderList = orderDao.selectOrderFuzzy(order);
        if (CollectionUtils.isEmpty(orderList))
            return true;
        else
            throw new FsException(ExceptionEnum.ITEM_LOCKED);
    }

    public void rejectRequest(Request request){
        requestDao.updateRequest(request);
    }

}
