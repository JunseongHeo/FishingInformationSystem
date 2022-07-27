package com.example.FIS.controller;


import com.example.FIS.model.dto.LoginDto;
import com.example.FIS.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("") // 로그인페이지 호출
    public String moveLoginPage(){
        return "login/main";
    }
    @GetMapping("/join") // 회원가입페이지 호출
    public String moveMemberJoinPage(){
        return "login/join";
    }
    @PostMapping("/join") // 회원가입
    public String memberJoin(LoginDto loginDto) {
        loginService.memberJoin(loginDto);
        return "redirect:/login";
    }
    @PostMapping("/login")  // 로그인
    public String memberLogin(HttpServletRequest request, LoginDto loginDto, RedirectAttributes rttr) {
        HttpSession session = request.getSession();
        LoginDto loginVo = loginService.memberLogin(loginDto);

        if (loginVo == null ) { // 로그인 실패
            int result = 0;
            rttr.addFlashAttribute("result", result);
        } else { // 로그인 성공
            session.setAttribute("member", loginVo);
        }
        return "redirect:/login";
    }
    @GetMapping("/logout") // 로그아웃
    public String memberLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("member");
        return "redirect:/login";
    }
//    @PostMapping("/logoutAjax") // 비동기방식 로그아웃
//    public  void memberLogoutAjax(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.invalidate();
//    }
    @GetMapping("/myPage") // 마이페이지 이동
    public String moveMyPage(){
        return "login/myPage";
    }
    @PostMapping("/myPage") // 회원정보 수정
    public String updateMemberInfo(LoginDto loginDto){
        loginService.updateMemberInfo(loginDto);
        return "redirect:/board";
    }
}
