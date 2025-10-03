
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoomController {

    @GetMapping("/")
    public String index() {
        return "chat"; // Form to enter room key and username
    }

    @PostMapping("/join")
    public String joinRoom(@RequestParam String username,
                           @RequestParam String roomKey,
                           Model model) {
        model.addAttribute("username", username);
        model.addAttribute("roomKey", roomKey);
        return "chat"; // Loads chat.html with room context
    }
}
