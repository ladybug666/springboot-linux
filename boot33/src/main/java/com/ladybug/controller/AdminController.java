package com.ladybug.controller;

import com.ladybug.entity.User;
import com.ladybug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {
    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
    @Autowired
    private UserService userService;
    @RequestMapping("/aa")
    public String aa(Model model){
        List<User> list=userService.select();
        model.addAttribute("list",list);
        return "show";
    }
    @RequestMapping("/add")
    public String add1(){
        return "add";
    }
}
