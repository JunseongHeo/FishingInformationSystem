package com.example.FIS.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String id; // 회원 id
    private String pw; // 회원 비밀번호
    private String userName; // 회원 이름
    private String gender; // 회원 성별
    private String phone; // 회원 전화번호
    private String email; // 회원 이메일
    private String address; // 회원 주소
    private Timestamp registerDate; // 회원 가입일
}
