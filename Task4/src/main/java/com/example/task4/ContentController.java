package com.example.task4;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ContentController {


    @MessageMapping("/base")
    @SendTo("/topic/message")
    public BaseContent message(BaseContent message) {
        System.out.println(message.getContent());
        return message;
    }

}