package com.baby.babycareproductsshop.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardUpdDto {
    @Schema(title = "게시글 PK", description = "")
    private int iboard;
    @Schema(title = "회원 PK", description = "")
    private int iuser; // 수정 2024-01-18
    @Schema(title = "게시글 제목", description = "")
    private String title;
    @Schema(title = "게시글 내용", description = "")
    private String contents;
    @Schema(title = "게시글 사진", description = "")
    private List<MultipartFile> pics;
}