package com.example.FIS.controller;

import com.example.FIS.model.dto.ArticlesDto;
import com.example.FIS.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class MainController {
    BoardService boardService;
    @Autowired
    public MainController(BoardService boardService) {
        this.boardService = boardService;
    }
    @GetMapping("")
    public String List(Model model){ // 외부 호출 메서드명과 상관 없음
        List<ArticlesDto> articles = boardService.findAll();
        model.addAttribute("Articles", articles);
        return "board/list";
    }
    @GetMapping("write")
    public String writeArticle(){
        return "board/write";
    }
    @PostMapping("write") // 수정 ("")
    public String create(ArticlesDto articles){
        boardService.create(articles);
        return "redirect:/boards"; // "redirect:/boards"
    }
    @GetMapping("/view/{article_id}")
    public String viewId(@PathVariable Long article_id, Model model) {
        ArticlesDto article = boardService.findOne(article_id);

        model.addAttribute("Article", article);

        return "board/read";
    }
    @GetMapping("/view/{article_id}/delete")
    public String delete(@PathVariable Long article_id){
        boardService.deleteList(article_id);
        return "redirect:/boards";
    }
    @GetMapping("/view/{article_id}/update")
    public String updateForm(@PathVariable Long article_id,Model model){
        ArticlesDto article = boardService.findOne(article_id);
        model.addAttribute("Article", article);
        return "board/update";
    }
    @PostMapping("/view/{article_id}/update")
    public String update(ArticlesDto articles){
        boardService.update(articles);
        return "redirect:/boards";
    }


}
