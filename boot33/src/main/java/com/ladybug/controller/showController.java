package com.ladybug.controller;

import com.ladybug.entity.Person;
import com.ladybug.entity.User;
import com.ladybug.service.PersonService;
import com.ladybug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class showController {

    @Autowired
    private UserService userService;
    @RequestMapping("/show")
    public String show(Model model){
        List<User> list=userService.select();
        model.addAttribute("list",list);
        return "show";
    }
    @RequestMapping("/addData")
    public String add(User user){
        System.out.println(user.getId());
        userService.add(user);
        return "redirect:show";
    }
    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable Integer id,Model model){
        User user=userService.find(id);
        model.addAttribute("user",user);
        return "update";
    }
    @RequestMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:show";
    }
    @RequestMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return "redirect:/show";
    }
}
