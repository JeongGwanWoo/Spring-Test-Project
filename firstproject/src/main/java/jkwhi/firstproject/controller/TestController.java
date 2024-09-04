package jkwhi.firstproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("data", "hoho");
        return "hello";
    }
}
