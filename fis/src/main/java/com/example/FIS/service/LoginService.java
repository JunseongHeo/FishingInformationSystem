package com.example.FIS.service;

import com.example.FIS.model.dao.LoginMapper;
import com.example.FIS.model.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {
    LoginMapper loginMapper;
    @Autowired
    public LoginService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }
    public void memberJoin(LoginDto loginDto) { // 회원가입
        loginMapper.memberJoin(loginDto);
    }

    public LoginDto memberLogin(LoginDto loginDto) { // 로그인
        return loginMapper.memberLogin(loginDto);
    }



}