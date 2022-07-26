package com.example.FIS.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketDto {
    private String p_id; // 상품코드
    private String p_name; // 상품명
    private int p_unitPrice; // 상품가격
    private String p_description; // 상품설명
    private String p_manufacturer; // 제조사
    private String p_category; // 분류
    private long p_unitsInStock; // 재고수
    private String p_condition; // 상품상태
    private String p_filename; // 상품이미지
    private int quantity;
    private String p_user; // 상품등록 유저아이디
}
