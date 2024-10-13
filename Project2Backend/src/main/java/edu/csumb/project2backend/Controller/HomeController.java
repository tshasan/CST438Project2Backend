package edu.csumb.project2backend.Controller;
import edu.csumb.project2backend.entities.User;
import java.util.Optional;

import edu.csumb.project2backend.service.ItemService;
import edu.csumb.project2backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @PostMapping("/newuser")
    public ResponseEntity<String> createUser(@RequestParam String username, @RequestParam String password) {
        userService.createUser(username, password);
        return ResponseEntity.ok("Success Account created! Welcome!! " + username);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            session.setAttribute("username", username);
            return ResponseEntity.ok("Welcome! " + username);
        }
        return ResponseEntity.status(401).body("Invalid credentials.");
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("User logged out.");
    }
    @DeleteMapping("/deleteaccount")
    public ResponseEntity<String> deleteAccount(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            userService.deleteUser(user.get());
            session.invalidate();
            return ResponseEntity.ok("Account Deleted.");
        }
        return ResponseEntity.status(401).body("Invalid credentials.");
    }



    @GetMapping("/")
    public String home(){
        return "This is the root! Woohoo!!";
    }

    @GetMapping("/secured")
    public String secured(){
        return "Secured!";
    }

}
