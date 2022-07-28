package com.example.FIS.service;

import com.example.FIS.model.dao.LoginMapper;
import com.example.FIS.model.dto.DeliveryDto;
import com.example.FIS.model.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginMapper loginMapper;

    public void memberJoin(LoginDto loginDto) {
        loginMapper.memberJoin(loginDto);
    } // 회원가입

    public LoginDto memberLogin(LoginDto loginDto) {
        return loginMapper.memberLogin(loginDto);
    } // 로그인
    public void updateMemberInfo(LoginDto loginDto) {
        loginMapper.updateMemberInfo(loginDto);
    } // 회원정보 수정
    public LoginDto findId(LoginDto loginDto){
        return loginMapper.findId(loginDto);
    } // 아이디 찾기
    public LoginDto findPw(LoginDto loginDto){
        return loginMapper.findPw(loginDto);
    } // 비밀번호 찾기
    public List<DeliveryDto> deliveryInfo(String p_user){
        return loginMapper.deliveryInfo(p_user);
    } // 배송 현황 조회
}