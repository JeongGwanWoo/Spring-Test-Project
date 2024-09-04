package jkwhi.firstproject.controller;

import jkwhi.firstproject.domain.Board;
import jkwhi.firstproject.repository.BoardRepository;
import jkwhi.firstproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

    private final BoardService boardService;

    /*@GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("data", "hoho");
        return "hello";
    }*/

    @GetMapping("/")
    public String home() {

        return "home";
    }

    @GetMapping("/board/write")
    public String createForm(Model model) {
        model.addAttribute("form", new TestForm());
        return "board/write";
    }

    @PostMapping("/board/write")
    public String write(TestForm form) {
        Board board = new Board();
        board.setName(form.getName());
        board.setTitle(form.getTitle());
        board.setContent(form.getContent());

        log.info(form.getName() + " / " + form.getTitle() + " / " + form.getContent());
        log.info(board.getName() + " / " + board.getTitle() + " / " + board.getContent());

        boardService.saveBoard(board);

        return "redirect:/";
    }
}
