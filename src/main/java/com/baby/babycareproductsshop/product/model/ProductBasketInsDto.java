package com.baby.babycareproductsshop.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "장바구니 넣을 때 필요한 데이터")
public class ProductBasketInsDto {

    @Schema(title = "유저 PK")
    @JsonIgnore
    private int iuser;

    @Schema(title = "상품 PK")
    private int iproduct;

    @Schema(title = "해당 물품 수량 수")
    private int productCnt;
}
