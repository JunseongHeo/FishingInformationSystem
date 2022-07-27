package com.example.FIS.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDto {
    private String p_id;
    private String p_user;
    private String buyer;
    private String buyer_name;
    private String buyer_phone;
    private String buyer_address;
}
