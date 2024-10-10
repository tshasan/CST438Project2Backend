package edu.csumb.project2backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "This is the root! Woohoo!!";
    }

}
