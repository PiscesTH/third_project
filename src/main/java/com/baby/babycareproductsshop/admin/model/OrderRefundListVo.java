package com.baby.babycareproductsshop.admin.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderRefundListVo {
    @Schema(title = "주문번호", description = "")
    private int iorder;
    @Schema(title = "주문일시", description = "")
    private String orderedAt;
    @Schema(title = "이미지", description = "")
    private String repPic;
    @Schema(title = "주문상품 정보", description = "")
    private String productNm;
    @Schema(title = "수량", description = "")
    private int cnt;
    @Schema(title = "상품금액", description = "")
    private int productPrice;
    @Schema(title = "처리상태", description = "")
    private int processState;
    @Schema(title = "반품일시", description = "")
    private String refundedAt;
    @Schema(title = "주문자", description = "")
    private String ordered;
}
