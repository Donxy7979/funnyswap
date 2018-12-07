package com.funnyswap.domain;

import lombok.Data;

@Data
public class User {
    Integer id;
    String memberId;
    String memberAccount;
    String memberPassword;
    String memberEmail;
    String memberPhone;
    Integer delFlag;
}
