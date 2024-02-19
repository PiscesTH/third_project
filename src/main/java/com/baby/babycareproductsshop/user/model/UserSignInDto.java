package com.baby.babycareproductsshop.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.baby.babycareproductsshop.common.Const.NM_IS_BLANK;
import static com.baby.babycareproductsshop.common.Const.PASSWORD_IS_BLANK;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignInDto {
    @Schema(title = "아이디" ,defaultValue = "hubble")
    @NotBlank(message = NM_IS_BLANK)
    private String uid;
    @Schema(title = "비밀번호" ,defaultValue = "xptmxm12!@")
    @NotBlank(message = PASSWORD_IS_BLANK)
    private String upw;
    @JsonIgnore
    @Schema(defaultValue = "LOCAL")
    private String providerType;
}
