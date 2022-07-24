package com.example.FIS.model.dao;

import com.example.FIS.model.dto.LoginDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface LoginMapper {

    void memberJoin(LoginDto loginDto); // 회원가입
    public LoginDto memberLogin(LoginDto loginDto); // 로그인

}
