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
public class UserVeiwcontroller {

    @Autowired
    private TodoApiService todoApiService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {

        if (error != null) {
            model.addAttribute("error", true);
        }
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }


}
