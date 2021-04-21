package com.ladybug.service;

import com.ladybug.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface GoodsService {
    public List<Goods> selectAll();
    public void addGoods(Goods goods);
    public Goods find(Integer id);
    public void updateGoods(Goods goods);
    public void deleteGoods(Integer id);
}
