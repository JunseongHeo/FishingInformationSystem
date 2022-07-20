package com.example.FIS.model.dao;

import com.example.FIS.model.dto.ArticlesDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    List<ArticlesDto> findAll();

    void create(ArticlesDto articles);

    ArticlesDto findOne(Long id);

    void deleteList(Long article_id);

    void update(ArticlesDto articles);
}
