package com.ladybug.controller;

import com.ladybug.entity.Goods;
import com.ladybug.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class updateGoods {
    @Qualifier("goodsServiceImp")
    @Autowired
    private GoodsService service;
    @RequestMapping("updateGoods11/{id}")
    public String update(@PathVariable Integer id, Model model){
        Goods goods=service.find(id);
        model.addAttribute("goods",goods);
        return "updatePage";
    }
    @RequestMapping("/updateGoodsImp")
    public String updateGoodsImp(Goods goods, MultipartFile file) throws IOException {
        String imgName=null;
        if(file.isEmpty()){
            System.out.println("文件为空");
        }
        String fileName=file.getOriginalFilename();
        String newFile= UUID.randomUUID()+fileName;
        File f=new File("/update/",newFile);
        file.transferTo(f);
        imgName="/update/"+newFile;
        goods.setPicture(imgName);
        service.updateGoods(goods);
        return "redirect:/goodsFind";
    }
}
