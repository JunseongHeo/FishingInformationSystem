package com.example.FIS.model.dao;

import com.example.FIS.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MarketMapper {

    void createProductPage(BoardDto boardDto); // C; 상품 페이지 등록
    List<BoardDto> getMarketList(); // R; 상품 목록 조회
    BoardDto getProductPage(int bno); // R; 개별 상품 페이지 조회
    void updateHits(int bno); // U; 조회수 증가
    int deleteProductPage(int bno); // D; 상품 페이지 삭제
    int updateProductPage(BoardDto boardDto); // U; 상품 페이지 수정

    void addCart(BoardDto boardDto); // C; 장바구니에 상품 등록
    List<BoardDto> getCartList(); // R; 장바구니 목록 조회
    int deleteCart(int bno); // D; 장바구니에서 상품 삭제

}
