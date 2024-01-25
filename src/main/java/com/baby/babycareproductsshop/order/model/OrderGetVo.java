package com.baby.babycareproductsshop.order.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class OrderGetVo {
    @Schema(title = "배송 처리 상태", description = "")
    private int processState;
    @Schema(title = "상품 PK", description = "")
    private int iproduct;
    @Schema(title = "주문 일자", description = "")
    private String createdAt;
    @Schema(title = "주문 번호", description = "")
    private int idetails;
    @Schema(title = "상품 이름", description = "")
    private String productNm;
    @Schema(title = "상품 수량", description = "")
    private int productCnt;
    @Schema(title = "상품별 총 금액", description = "")
    private int price;
    @Schema(title = "환불 여부", description = "")
    private int refundFl;
    @Schema(title = "리뷰 작성 여부", description = "")
    private int reviewFl;
}