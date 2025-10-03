package com.example.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {


    @GetMapping("/chat")
    public String chatPage() {
        return "chat"; // Loads templates/chat.html
    }


    @GetMapping("/home")
    public String homeRedirect() {
        return "redirect:/chat"; // Redirects root to chat page
    }
}
