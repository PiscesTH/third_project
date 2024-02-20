package com.baby.babycareproductsshop.admin.model;

import lombok.Data;

@Data
public class OrderSmallFilterDto {
    private int searchCategory; // 검색 카테고리
    private String keyword; // 검색어
    private String startDate; // 시작 날짜
    private String lastDate; // 종료 날짜
    private int dateFl; // 기간 선택
    private int payCategory; // 결제 방법
    private int sort; // 정렬
}
