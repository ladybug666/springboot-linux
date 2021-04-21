package com.ladybug.controller;

import com.ladybug.entity.User;
import com.ladybug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {
    @Qualifier("userServiceImp")
    @Autowired
    private UserService service;
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,HttpSession session){
        User user= service.login(username,password);

        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:index";
        }
        return "login";
    }
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
