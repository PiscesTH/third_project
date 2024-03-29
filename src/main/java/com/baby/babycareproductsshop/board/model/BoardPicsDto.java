package com.baby.babycareproductsshop.board.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class BoardPicsDto {
    @Schema(title = "게시글 PK", description = "")
    private int iboard;

    //    @Schema(title = "게시판 식별코드", description = "1. 공지사항 2. 소통해요 3. 1:1 문의")
//    private int boardCode;

    @Schema(title = "게시글 사진", description = "")
    private List<MultipartFile> pics = new ArrayList<>();

    @Schema(title = "게시글 사진 이름", description = "UUID + ext(확장자)")
    private List<String> picNames = new ArrayList<>();

//    @Schema(title = "게시글 사진 이름", description = "UUID + ext(확장자)")
    @JsonIgnore
    private String picName;
}