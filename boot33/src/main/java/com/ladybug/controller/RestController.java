package com.ladybug.controller;

import com.ladybug.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RestController {

    @RequestMapping("/ces{id}")
    public String aa(@PathVariable String id){
        System.out.println(id);
        return "ces";
    }
}
