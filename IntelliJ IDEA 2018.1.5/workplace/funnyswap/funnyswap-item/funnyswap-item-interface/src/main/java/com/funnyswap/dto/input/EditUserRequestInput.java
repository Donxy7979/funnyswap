package com.funnyswap.dto.input;

import lombok.Data;

@Data
public class EditUserRequestInput {
    String memberId;
    String memberAccount;
    String memberPassword;
    String memberEmail;
    String memberPhone;
}
