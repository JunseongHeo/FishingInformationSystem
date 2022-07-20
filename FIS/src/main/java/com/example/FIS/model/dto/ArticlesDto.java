package com.example.FIS.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlesDto {
    private Long article_id;
    private String article_title;
    private String article_text;
    private Long member_id;
}