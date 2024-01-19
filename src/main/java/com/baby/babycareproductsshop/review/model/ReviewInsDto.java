package com.baby.babycareproductsshop.review.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Data
@Schema(title = "리뷰 작성 시 필요한 데이터")
public class ReviewInsDto {
    @Schema(title = "주문상세 KEY")
    private int ireview;
    @Schema(title = "주문 PK")
    private int iorder;
    @JsonIgnore
    private int iproduct;
    @JsonIgnore
    private int iuser;
    @Schema(title = "리뷰 내용")
    private String contents;
    @Schema(title = "리뷰 별점")
    @Min(1) @Max(5)
    private int productScore;
    @Schema(title = "리뷰 첨부사진")
    private List<MultipartFile> pics;
}
