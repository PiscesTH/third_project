package com.baby.babycareproductsshop.mail.model;

import lombok.Data;

import java.util.List;

@Data
public class EmailMessageDto {
    private List<String> to;
    private String subject;
    private String message;
}
