package com.den.tasklist.controllers;

import com.den.tasklist.repositories.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final TodoRepository todoRepository;

    public HomeController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public ModelAndView home(){
        var modelAndView = new ModelAndView("home");
        modelAndView.addObject("nome", "Vinícius Silva");
        var alunos = List.of("Vinicius Silva", "Leticia Lima", "João Vinícius");
        modelAndView.addObject("alunos", alunos);
        modelAndView.addObject("ehProgramador", false);


        var todos = todoRepository.findAll();
        System.out.println(todos);

        return modelAndView;
    }
}
