package com.example.todo.userapi.service;

import com.example.todo.userapi.dto.request.UserRequestSignUpDTO;
import com.example.todo.userapi.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserServiceTest {

    @Autowired
    UserService userService;

    //중복이메일로 작성하면 exception이 발생하는가?
    //비번 인코딩되는가

    @Test
    @DisplayName("중복된 이메일로 회원가입을 시도하면 runtimeexception이  발생되어야한다")
    void validateEmailTest() {
        //given
        String email = "abc123@abc.com";

        UserRequestSignUpDTO dto = UserRequestSignUpDTO.builder()
                .email(email)
                .password("aaa")
                .userName("aaa")
                .build();
        //when

        //then -- error가 떠야 test 성공
        //error 발생을 단언
        //param1: 어떤 에러가 발생할지 에러클래스 작성
        //param2: 에러가 발생하는 상황을 전달
    assertThrows(RuntimeException.class, () ->{ userService.create(dto); });


    }
}