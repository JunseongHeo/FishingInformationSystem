package com.example.FIS.model.dao;

import com.example.FIS.model.dto.DeliveryDto;
import com.example.FIS.model.dto.LoginDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface LoginMapper {

    void memberJoin(LoginDto loginDto); // 회원가입
    LoginDto memberLogin(LoginDto loginDto); // 로그인
    void updateMemberInfo(LoginDto loginDto); // 회원정보 수정
    LoginDto findId(LoginDto loginDto); // 아이디 찾기
    LoginDto findPw(LoginDto loginDto);  // 비밀번호 찾기
    List<DeliveryDto> deliveryInfo(String p_user); // 배송 현황 정보

}
