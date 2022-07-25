package com.example.FIS.controller;

import com.example.FIS.service.LoginService;
import com.example.FIS.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/market")
public class MarketController {
    MarketService marketService;
    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }
    @GetMapping("")
    public String moveLoginPage(){
        return "market/main"; // 마켓 메인페이지 호출
    }


}
