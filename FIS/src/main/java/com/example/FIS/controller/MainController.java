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
    @GetMapping("/login")
    public String Login(){
        return "board/login"; // 로그인페이지 호출
    }
//    @GetMapping("/board")
//    public String Board(){
//        return "board/main"; // 게시판페이지 호출
//    }
}
