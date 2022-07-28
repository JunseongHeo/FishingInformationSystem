package com.example.FIS.controller;


import com.example.FIS.model.dto.DeliveryDto;
import com.example.FIS.model.dto.LoginDto;
import com.example.FIS.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @GetMapping("/myPage") // 마이페이지
    public String moveMyPage(){
        return "login/myPage";
    }
    @GetMapping("/myInfoUpdate") // 회원정보 수정페이지 이동
    public String moveMyInfoUpdate(){
        return "login/myInfoUpdate";
    }
    @PostMapping("/myPage") // 회원 정보 수정 + 로그아웃
    public String updateMemberInfo(LoginDto loginDto, HttpServletRequest request){
        loginService.updateMemberInfo(loginDto);
        HttpSession session = request.getSession();
        session.removeAttribute("member");
        return "redirect:/login/myPage";
    }
    @GetMapping("/findId") // 아이디 찾기 이동
    public String moveFindId(){
        return "login/findId";
    }
    @GetMapping("/findPw") // 비밀번호 찾기 이동
    public String moveFindPw(){
        return "login/findPw";
    }
    @PostMapping("/findId") // 아이디 찾기
    public String findId(LoginDto loginDto, Model model) {
        LoginDto loginValidate = loginService.findId(loginDto);
        if ( loginValidate != null) {
            model.addAttribute("check", 1); // 아이디 찾기 성공
            model.addAttribute("id", loginValidate.getId());
        } else {
            model.addAttribute("check", 0); // 아이디찾기 실패
        }
        return "login/findId";
    }
    @PostMapping("/findPw") // 비밀번호 찾기
    public String findPw(LoginDto loginDto, Model model) {
        LoginDto loginValidate = loginService.findPw(loginDto);
        if ( loginValidate != null) {
            model.addAttribute("check", 1); // 비밀번호 찾기 성공
            model.addAttribute("Pw", loginValidate.getPw());
        } else {
            model.addAttribute("check", 0); // 비밀번호 실패
        }
        return "login/findPw";
    }
    @GetMapping("/deliveryInfo")
    public String moveDeliveryInfo() {
        return "login/deliveryInfo";
    }
    @PostMapping("/deliveryInfo") // 배송 현황 조회
    public String findDeliveryInfo(Model model, String p_user) {
        List<DeliveryDto> currentInfo = loginService.deliveryInfo(p_user);
        System.out.println("1");
        if ( currentInfo != null) {
            model.addAttribute("check", 1); // 배송 정보 조회 성공
            model.addAttribute("deliInfo", currentInfo);
            System.out.println("2");
        } else {
            model.addAttribute("check", 0); // 등록된 배송 정보가 없습니다.
            System.out.println("3");
        }
        return "login/deliveryInfo";
    }
}
