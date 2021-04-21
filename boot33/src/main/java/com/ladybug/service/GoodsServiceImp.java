package com.ladybug.service;

import com.ladybug.dao.GoodsMapper;
import com.ladybug.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImp implements GoodsService {
    @Autowired
    private GoodsMapper mapper;
    @Override
    public List<Goods> selectAll() {
        List<Goods> list=mapper.selectAll();
        return list;
    }

    @Override
    public void addGoods(Goods goods) {
        mapper.addGoods(goods);
    }

    @Override
    public Goods find(Integer id) {
        Goods goods=mapper.find(id);
        return goods;
    }

    @Override
    public void updateGoods(Goods goods) {
        mapper.updateGoods(goods);
    }

    @Override
    public void deleteGoods(Integer id) {
        mapper.deleteGoods(id);
    }
}
