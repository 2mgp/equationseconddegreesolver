package com.example.equationseconddegree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquationPageController {

    @GetMapping("/form_equation")
    public String showEquationSolverForm() {
        return "EquationSolverForm";
    }
}

