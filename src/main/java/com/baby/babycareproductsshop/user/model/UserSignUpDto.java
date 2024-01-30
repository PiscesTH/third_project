package com.baby.babycareproductsshop.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

import static com.baby.babycareproductsshop.common.Const.*;

@Data
@Schema(title = "회원가입 시 필요한 고객 요청 데이터")
public class UserSignUpDto {
    @JsonIgnore
    private int iuser;

    @Schema(description = "유저 아이디", example = "Test1234")
    @NotNull(message = ID_IS_BLANK)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z0-9]{4,10}$",
            message = NOT_ALLOWED_ID)
    private String uid;

    @Schema(description = "유저 비밀번호", example = "특수문자는 @$!%*?&#~_-를 사용할 수 있습니다.")
    @NotNull(message = PASSWORD_IS_BLANK)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&#~_-])[A-Za-z\\d@$!%*?&#.~_-]{8,16}$",
            message = NOT_ALLOWED_PASSWORD)
    private String upw;

    @Schema(title = "이름")
    @NotBlank(message = NM_IS_BLANK)
    private String nm;

    @Schema(title = "우편 번호")
    @NotBlank(message = ZIP_CODE_IS_BLANK)
    private String zipCode;

    @Schema(title = "주소")
    @NotBlank(message = ADDRESS_IS_BLANK)
    private String address;

    @Schema(title = "상세 주소")
    @NotBlank(message = ADDRESS_DETAIL_IS_BLANK)
    private String addressDetail;

    @Schema(title = "전화번호")
    @NotNull(message = PHONE_NUMBER_IS_BLANK)
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}",
            message = NOT_ALLOWED_PHONE_NUMBER)
    private String phoneNumber;

    @Schema(title = "이메일")
    @NotNull(message = EMAIL_IS_BLANK)
    @Pattern(regexp = "\\w+@\\w{3,}\\.([a-zA-Z]{2,}|[a-zA-Z]{2,}\\.[a-zA-Z]{2,})",
            message = NOT_ALLOWED_EMAIL)
    private String email;

    @Schema(title = "자녀 정보")
    @Size(min = 1, max = 3, message = NOT_ALLOWED_CHILDREN_COUNT)
    private List<@Valid UserChildDto> children;
}