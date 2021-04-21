package com.ladybug.dao;

import com.ladybug.entity.Goods;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsMapper {
    public List<Goods> selectAll();
    public void addGoods(Goods goods);
    public Goods find(Integer id);
    public void updateGoods(Goods goods);
    public void deleteGoods(Integer id);
}
