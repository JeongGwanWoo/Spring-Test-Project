package jkwhi.firstproject.controller;

import jkwhi.firstproject.domain.Board;
import jkwhi.firstproject.domain.BoardStatus;
import jkwhi.firstproject.repository.BoardRepository;
import jkwhi.firstproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        board.setStatus(BoardStatus.INCLUDE);

        log.info(form.getName() + " / " + form.getTitle() + " / " + form.getContent());
        log.info(board.getName() + " / " + board.getTitle() + " / " + board.getContent());

        boardService.saveBoard(board);

        return "redirect:/";
    }

    @GetMapping("/board/list")
    public String list(Model model) {
        List<Board> posts = boardService.findPosts();

        model.addAttribute("posts", posts);

        return "board/list";
    }

    @GetMapping("/board/{boardId}/edit")
    public String updateBoardForm(@PathVariable("boardId") Long boardId, Model model) {
        Board board = boardService.findOne(boardId);

        TestForm form = new TestForm();
        form.setId(board.getId());
        form.setName(board.getName());
        form.setTitle(board.getTitle());
        form.setContent(board.getContent());

        model.addAttribute("form", form);

        return "board/updateBoard";
    }

    @PostMapping("/board/{boardId}/edit")
    public String updateBoard(@PathVariable("boardId") Long boardId, @ModelAttribute("form") TestForm form) {
        boardService.updateBoard(boardId, form.getName(), form.getTitle(), form.getContent());

        return "redirect:/board/list";
    }

    @PostMapping("/board/{boardId}/delete")
    public String deleteBoard(@PathVariable("boardId") Long boardId) {
        log.info("delete gogo");
        boardService.deleteBoard(boardId);

        return "redirect:/board/list";
    }
}
