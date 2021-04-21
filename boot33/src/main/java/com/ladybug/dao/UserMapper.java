package com.ladybug.dao;

import com.ladybug.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public User login(String username,String password);
    public List<User> select();
    public void add(User user);
    public User find(Integer id);
    public void update(User user);
    public void delete(Integer id);
}
