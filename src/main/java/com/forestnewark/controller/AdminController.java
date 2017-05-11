package com.forestnewark.controller;

import com.forestnewark.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by forestnewark on 5/11/17.
 */
@Controller
public class AdminController {
    final
    MessageRepository messageRepository;

    @Autowired
    public AdminController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @RequestMapping("/adminpage")
    public String adminPage(ModelMap model) {
        model.addAttribute("messages",messageRepository.findAll());

        return "adminpage";

    }

    @RequestMapping("/deleteMessage")
    public RedirectView deleteMessage(Integer messageId){

        messageRepository.delete(messageId);
        return new RedirectView("/adminpage");
    }
}
