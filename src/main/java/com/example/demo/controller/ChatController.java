
package com.example.demo.controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.example.demo.model.ChatMessage;
@Controller
public class ChatController {
   @MessageMapping("/chat/{roomKey}")
   @SendTo("/topic/{roomKey}")
   public ChatMessage sendToRoom(@DestinationVariable String roomKey, ChatMessage message) {
       return message;
   }
}
