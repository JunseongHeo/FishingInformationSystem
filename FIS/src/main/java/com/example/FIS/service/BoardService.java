package com.example.FIS.service;

import com.example.FIS.model.dao.BoardMapper;
import com.example.FIS.model.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    BoardMapper boardMapper;
    @Autowired
    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }
    public void createPost(BoardDto boardDto){ // 게시글 생성
        boardMapper.createPost(boardDto);
    }
    public List<BoardDto> getList(){ // 게시글 목록 조회
        return boardMapper.getList();
    }
    public BoardDto getPost(int bno){ // 개별 게시글 조회 + 조회수 증가
        boardMapper.updateHits(bno);
        return boardMapper.getPost(bno);
    }
    public int deletePost(int bno){ // 게시글 삭제
        return boardMapper.deletePost(bno);
    }
    public int updatePost(BoardDto boardDto){ // 게시글 수정
        return boardMapper.updatePost(boardDto);
    }

}