package com.baby.babycareproductsshop.admin.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderBatchProcessDto {
    private List<Integer> iorders;
    private int processState;
}
