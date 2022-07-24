package com.example.FIS.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int bno; // 게시글 기본키 넘버링
    private String title; // 게시글 제목
    private String contents; // 게시글 내용
    private String userId; // 로그인회원 아이디
    private String userName; // 로그인회원 이름
    private Timestamp registerDate; // 글 작성일
    private int hits; // 게시글 조회수

}