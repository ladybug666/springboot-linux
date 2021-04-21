package com.ladybug.controller;

import com.ladybug.entity.Goods;
import com.ladybug.entity.User;
import com.ladybug.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Check {
    @Qualifier("goodsServiceImp")
    @Autowired
    private GoodsService service;
    @RequestMapping("/check")
    @ResponseBody
    public List<Goods> aa(){
        List<Goods> list=service.selectAll();
        return list;
    }
}
