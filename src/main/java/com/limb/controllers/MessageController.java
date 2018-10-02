package com.limb.controllers;

import com.limb.domain.Message;
import com.limb.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MessageController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/message")
    public String message(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "message";
    }

    @PostMapping("/message")
    public String addMessages(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "message";
    }

    @PostMapping("searchMessage")
    public String search(@RequestParam String filter, Map<String, Object> model){
        Iterable<Message> messages;
        if(filter != null && !filter.isEmpty()){
            messages = messageRepo.findByTag(filter);
        }else{
            messages = messageRepo.findAll();
        }
        model.put("messages", messages);
        return "message";
    }
}
