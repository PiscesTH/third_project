package com.baby.babycareproductsshop.review;

import com.baby.babycareproductsshop.common.ResVo;
import com.baby.babycareproductsshop.review.model.ReviewDelDto;
import com.baby.babycareproductsshop.review.model.ReviewInsDto;
import com.baby.babycareproductsshop.review.model.ReviewSelDto;
import com.baby.babycareproductsshop.review.model.ReviewSelVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
@Tag(name = "리뷰 API", description = "리뷰 관련 파트")
public class ReviewController {

    private final ReviewService service;

    @PostMapping("/{iproduct}")
    @Operation(summary ="리뷰 작성", description = "리뷰 작성 절차")
    public ResVo insReview(@PathVariable int iproduct,
                           @RequestPart(required = false) List<MultipartFile> pics,
                           @RequestPart ReviewInsDto dto){
        log.info("pics = {}",pics.size());
        log.info("dto = {}", dto);
        dto.setIproduct(iproduct);
        dto.setPics(pics);
        return service.insReview(dto);
    }

    @GetMapping
    @Operation(summary = "리뷰 목록", description = "리뷰 전체 리스트")
    public List<ReviewSelVo> getReview(ReviewSelDto dto){
        log.info("dto = {}",dto);
        return service.getReview(dto);
    }

    @DeleteMapping
    @Operation(summary = "리뷰 삭제", description = "리뷰 삭제 절차")
    public ResVo delReview(ReviewDelDto dto){
        log.info("dto = {}",dto);
        return service.delReview(dto);
    }
}
