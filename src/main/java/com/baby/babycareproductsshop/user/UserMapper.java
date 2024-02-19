package com.baby.babycareproductsshop.user;

import com.baby.babycareproductsshop.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpDto dto);
    UserSelMyInfoVo selMyInfo(int iuser);
    UserSignInProcDto selSignInInfoByUid(String uid, String providerType);
    UserSelToModifyVo selUserInfoByIuser(int iuser);
    List<UserClauseVo> selClause();
    int delUser(int iuser);
    int updUser(UserUpdDto dto);
}
