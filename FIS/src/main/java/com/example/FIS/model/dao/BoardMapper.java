package com.example.FIS.model.dao;

import com.example.FIS.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {

    void createPost(BoardDto boardDto); // C; 게시글 등록
    List<BoardDto> getList(); // R; 게시글 목록 조회
    BoardDto getPost(int bno); // R; 개별 게시글 조회
    void updateHits(int bno); // U; 조회수 증가
    int deletePost(int bno); // D; 게시글 삭제
    int updatePost(BoardDto boardDto); // U; 게시글 수정
}
