package com.funnyswap.dto.input;

import lombok.Data;

@Data
public class QueryUserRequestInput {
    String memberId;
    String memberEmail;
    String memberPhone;
}
