package ru.dnevnik.pohebeyy.dnevnik.controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dnevnik.pohebeyy.dnevnik.models.MyUser;
import ru.dnevnik.pohebeyy.dnevnik.models.Post;
import ru.dnevnik.pohebeyy.dnevnik.repositiry.PostGrade;
import ru.dnevnik.pohebeyy.dnevnik.services.AppService;


@Controller
public class MainController {
    private AppService service;
    @Autowired
    private PostGrade postGrade;
    @GetMapping("/")
    public String home(Model model) {
        Iterable<Post> posts = postGrade.findAll();
        model.addAttribute("posts",posts);
        return "home";
    }
    @GetMapping("/scedule")
    public String scedule(Model model){
        model.addAttribute("scedule");
        return "schedule";
    }
    @GetMapping("/journal")
    public String journal (Model model){
        return "journal";
    }
    @GetMapping("/teacher")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String teacher(Model model){
        return "teacher";
    }
    @PostMapping("/register")
    public String addUser(@RequestBody MyUser user){
        service.addUser(user);
        return  "user is saved";
    }
    @GetMapping("/author")
    public String author(Model model){
        return "author";
    }
    @GetMapping("/teacher/grade")
    public String grade(Model model){
        return "teacher-grade";
    }
    @PostMapping("/teacher/grade")
    public String gradeTeacher(@RequestParam int grade, Model model){
        Post post = new Post(grade);
        postGrade.save(post);
        return "redirect:/";
    }
}
