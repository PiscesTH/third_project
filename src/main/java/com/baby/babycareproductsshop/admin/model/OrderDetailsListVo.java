package com.baby.babycareproductsshop.admin.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderDetailsListVo {
    private int iorder;
    private String orderedAt;
    private List<OrderProductVo> products;
    private String ordered;
    private String recipient;
    private int totalAmount;
    private int payCategory;
    private int buyComfirmFl;
}
