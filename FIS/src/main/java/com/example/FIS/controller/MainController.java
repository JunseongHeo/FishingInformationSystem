package com.example.FIS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("")
    public String Main() {
        return "index";
    }

    @GetMapping("/location")
    public String moveLocationPage(){
        return "location/location"; // 로그인페이지 호출
    }

}
