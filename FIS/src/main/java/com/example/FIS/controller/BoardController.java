package com.example.FIS.controller;

import com.example.FIS.model.dto.BoardDto;
import com.example.FIS.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("") // 게시판 메인화면. 게시글 목록 조회
    public String boardListUp(Model model){
        List<BoardDto> boardDto = boardService.getList();
        model.addAttribute("list", boardDto);
        return "board/main";
    }
    @GetMapping("/getPost/{bno}") // 개별 게시글 조회 + 조회수 증가
    public String boardGetPost(@PathVariable int bno, Model model) {
        BoardDto boardDto = boardService.getPost(bno);
        model.addAttribute("postInfo", boardDto);
        return "board/getPost";
    }
    @GetMapping("/createPost") // 게시글 작성 페이지이동
    public String boardMoveCreatePage(BoardDto boardDto){
        return "/board/createPost";
    }
    @PostMapping("/createPost") // 게시글 생성
    public String boardCreatePost(BoardDto boardDto){
        boardService.createPost(boardDto);
        return "redirect:/board";
    }

    @PostMapping("/getPost/{bno}/delete") // 게시글 삭제
    public String boardDeletePost(@PathVariable int bno){
        boardService.deletePost(bno);
        return "redirect:/board";
    }

    @GetMapping("/getPost/{bno}/update") // 게시글 수정 페이지이동
    public String boardMoveUpdatePost(@PathVariable int bno, Model model){
        BoardDto boardDto = boardService.getPost(bno);
        model.addAttribute("postInfo", boardDto);
        return "board/updatePost";
    }
    @PostMapping("/getPost/{bno}/update") // 게시글 수정
    public String boardUpdatePost(BoardDto boardDto){
        boardService.updatePost(boardDto);
        return "redirect:/board";
    }
}
