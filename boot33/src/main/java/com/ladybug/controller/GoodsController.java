package com.ladybug.controller;

import com.ladybug.entity.Goods;
import com.ladybug.service.GoodsService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
public class GoodsController {
    @Qualifier("goodsServiceImp")
    @Autowired
    private GoodsService service;
    @RequestMapping("/addGoods1")
    public String addGoods(@RequestParam("file") MultipartFile file,Goods goods) throws IOException {

        return getString(file, goods);
    }
    @RequestMapping("/addGoods")
    public String addGoo(){
        return "goodsAdd";
    }
    @RequestMapping("/goodsFind")
    public String goodsFind(Model model){
        List<Goods> list=service.selectAll();
        model.addAttribute("list",list);

        return "goodsList";
    }
    @RequestMapping("deleteGoods/{id}")
    public String delete(@PathVariable Integer id){
        service.deleteGoods(id);
        return "redirect:/goodsFind";
    }
    @RequestMapping("/updateGoods/{id}")
    public String update(@PathVariable Integer id, Model model){
        Goods goods=service.find(id);
        model.addAttribute("goods",goods);
        return "updateGoodsPage";
    }
    @RequestMapping("updateGoods1")
    private String getString(@RequestParam("file") MultipartFile file1, Goods goods) throws IOException {
        if(!file1.isEmpty()) {
            String newFileName = UUID.randomUUID() + file1.getOriginalFilename();
            File dest = new File("/update",newFileName);
            if (!dest.getParentFile().exists()) {
                dest.mkdirs();
            }
            file1.transferTo(dest);

            goods.setPicture("/update/"+newFileName);
            service.addGoods(goods);
        }
        return "redirect:/goodsFind";
    }
}
