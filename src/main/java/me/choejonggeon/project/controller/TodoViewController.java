package me.choejonggeon.project.controller;

import me.choejonggeon.project.Dto.CleanedTodo;
import me.choejonggeon.project.Entity.To_do;
import me.choejonggeon.project.Entity.User;
import me.choejonggeon.project.repository.UserRepository;
import me.choejonggeon.project.service.TodoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class TodoViewController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoApiService todoApiService;

    @GetMapping("/articles")
    public String articles(Model model, Principal principal) {

        String id = principal.getName();

        Optional<User> user = userRepository.findById(id);

        List<To_do> todoList = todoApiService.findAllByUserId(principal);

        List<CleanedTodo> temp = CleanedTodo.cleanData(todoList);

        model.addAttribute("todoList", temp);

        model.addAttribute("username", user.get().getName());

        return "/mainPage";
    }

    @GetMapping("/new-articles")
    public String newTo_do() {

        return "new_To_do";
    }

    @GetMapping("/update-todo")
    public String Update_To_do(@RequestParam Long id, Model model) {

        To_do update_todo = todoApiService.findById(id);

        model.addAttribute("todoList", update_todo);

        return "update_To_do";

    }

}
