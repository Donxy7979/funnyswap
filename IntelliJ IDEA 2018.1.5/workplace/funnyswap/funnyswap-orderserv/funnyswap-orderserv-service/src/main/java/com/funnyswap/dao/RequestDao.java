package com.funnyswap.dao;

import com.funnyswap.domain.Request;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RequestDao {
    List<Request> selectRequest(Request request);

    Integer insertRequest(Request request);

    void updateRequest(Request request);

    List<Request> selectRequestFuzzy(Request request);
}
