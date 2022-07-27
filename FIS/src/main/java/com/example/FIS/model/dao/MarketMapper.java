package com.example.FIS.model.dao;

import com.example.FIS.model.dto.BoardDto;
import com.example.FIS.model.dto.DeliveryDto;
import com.example.FIS.model.dto.MarketDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MarketMapper {

    List<MarketDto> getProductList(); // R; 상품 목록 조회
    MarketDto getProductInfo(String p_id); // R; 개별 상품 페이지 조회
    void addProduct(MarketDto marketDto); // C; 상품 등록
    void addProduct_delivery(DeliveryDto deliveryDto); // 판매자 상품 배송정보 등록
    void productDeliveryOrder(DeliveryDto deliveryDto); // 구매자 배송정보 등록
    DeliveryDto getDeliveryInfo(String p_id); // 상품 배송정보 조회
    void deleteProduct(String p_id); // D; 상품 페이지 삭제
    void editProduct(MarketDto marketDto); // U; 상품 페이지 수정
}

