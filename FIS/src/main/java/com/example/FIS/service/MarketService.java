package com.example.FIS.service;

import com.example.FIS.model.dao.BoardMapper;
import com.example.FIS.model.dao.MarketMapper;
import com.example.FIS.model.dto.BoardDto;
import com.example.FIS.model.dto.DeliveryDto;
import com.example.FIS.model.dto.MarketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MarketService {
    MarketMapper marketMapper;
    @Autowired
    public MarketService(MarketMapper marketMapper) {
        this.marketMapper = marketMapper;
    }

    public List<MarketDto> getProductList(){ // 상품 목록 조회
        return marketMapper.getProductList();
    } // 상품 목록 조회
    public MarketDto getProductInfo(String p_id){
        return marketMapper.getProductInfo(p_id);
    } // 개별 상품 상세정보 조회
    public DeliveryDto getDeliveryInfo(String p_id){
        return marketMapper.getDeliveryInfo(p_id);
    } // 개별 상품 배송정보 조회
    public void addProduct(MarketDto marketDto, DeliveryDto deliveryDto){
        marketMapper.addProduct(marketDto);
        marketMapper.addProduct_delivery(deliveryDto);
    } // C; 상품 등록 + 판매자 배송정보 등록
    public void deleteProduct(String p_id){
        marketMapper.deleteProduct(p_id);
    } // 상품 삭제
    public void editProduct(MarketDto marketDto){
        marketMapper.editProduct(marketDto);
    } // 게시글 수정
    public void productDeliveryOrder(DeliveryDto deliveryDto){
        marketMapper.productDeliveryOrder(deliveryDto);
    }
}
