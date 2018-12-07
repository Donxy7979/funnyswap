package com.funnyswap.dto.input;

import lombok.Data;

@Data
public class RegUserRequestInput {
    String memberAccount;
    String memberPassword;
    String memberEmail;
    String memberPhone;
}
