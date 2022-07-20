package com.example.FIS.service;

import com.example.FIS.model.dao.BoardMapper;
import com.example.FIS.model.dto.ArticlesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

    public List<ArticlesDto> findAll(){
        return boardMapper.findAll();
    }

    public void create(ArticlesDto articles){ boardMapper.create(articles);}

    public ArticlesDto findOne(Long id){ return boardMapper.findOne(id);  }

    public void deleteList(Long article_id){  boardMapper.deleteList(article_id);}

    public void update(ArticlesDto articles){ boardMapper.update(articles);}
}