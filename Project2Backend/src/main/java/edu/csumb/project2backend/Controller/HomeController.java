package edu.csumb.project2backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "This is the root! Woohoo!!";
    }

    @GetMapping("/secured")
    public String secured(){
        return "Secured!";
    }
}
