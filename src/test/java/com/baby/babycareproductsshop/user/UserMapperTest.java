package com.baby.babycareproductsshop.user;

import com.baby.babycareproductsshop.CharEncodingConfig;
import com.baby.babycareproductsshop.user.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@Import(CharEncodingConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    @DisplayName("ins user test")
    void insUser() {    //39
        UserSignUpDto dto = new UserSignUpDto();
        dto.setUid("test1122");
        dto.setUpw("asldnalkdfnlksdn!@3");
        dto.setNm("연보라");
        dto.setPhoneNumber("010-7777-8888");
        dto.setEmail("test1122@naver.com");
        int insResult = mapper.insUser(dto);
        assertEquals(1, insResult);
        UserSelMyInfoVo vo = mapper.selMyInfo(dto.getIuser());
        assertNotNull(vo);
        assertEquals("연보라", vo.getNm());
    }

    @Test
    @DisplayName("sel my info test")
    void selMyInfo() {
        int iuser = 38;
        UserSelMyInfoVo vo = mapper.selMyInfo(iuser);
        assertEquals("연보라", vo.getNm());
    }

    @Test
    @DisplayName("sel sign in info by uid")
    void selSignInInfoByUid() {
        String uid = "winter";
        UserSignInProcDto dto = mapper.selSignInInfoByUid(uid, "LOCAL");
        assertNotNull(dto);
        assertEquals(20 ,dto.getIuser());
    }

    @Test
    @DisplayName("sel user info by iuser")
    void selUserInfoByIuser() {
        int iuser = 19;
        UserSelToModifyVo vo = mapper.selUserInfoByIuser(iuser);
        assertEquals("하늘색", vo.getNm());
        assertEquals("011-0010-3924", vo.getPhoneNumber());
    }

    @Test
    @DisplayName("sel clause test")
    void selClause() {
        List<UserClauseVo> list = mapper.selClause();
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("del user test")
    void delUser() {
        int iuser = 27;
        int delResult = mapper.delUser(iuser);
        assertEquals(1, delResult);

        int iuser2 = 2;
        int delResult2 = mapper.delUser(iuser2);
        assertEquals(1, delResult2);
    }

    @Test
    void updUser() {
        UserUpdDto dto = new UserUpdDto();
        dto.setIuser(5);
        dto.setNm("자바");
        dto.setPhoneNumber("010-7777-4444");
        dto.setEmail("javax@gmail.com");
        int updResult = mapper.updUser(dto);
        assertEquals(1, updResult);
    }
}