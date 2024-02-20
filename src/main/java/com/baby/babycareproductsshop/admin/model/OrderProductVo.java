package com.baby.babycareproductsshop.admin.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderProductVo {
    @Schema(title = "이미지", description = "")
    private String repPic;
    @Schema(title = "주문상품", description = "")
    private String productNm;
    @Schema(title = "수량", description = "")
    private int cnt;
    @Schema(title = "처리상태", description = "")
    private int processState;
}
