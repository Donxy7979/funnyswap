package com.funnyswap.dto.input;

import lombok.Data;

@Data
public class SwapRequestInput {
    String memberAId;
    String itemAId;
    String memberBId;
    String itemBId;
}
