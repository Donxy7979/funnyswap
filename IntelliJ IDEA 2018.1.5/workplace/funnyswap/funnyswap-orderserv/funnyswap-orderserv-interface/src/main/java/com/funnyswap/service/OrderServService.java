package com.funnyswap.service;

import com.funnyswap.domain.Request;

public interface OrderServService {
    void sendRequest(Request request);

    void accept(Request request);

    void rejectRequest(Request request);
}
