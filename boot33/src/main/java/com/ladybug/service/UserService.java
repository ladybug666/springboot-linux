package com.ladybug.service;

import com.ladybug.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User login(String username, String password);
    public List<User> select();
    public void add(User user);
    public User find(Integer id);
    public void update(User user);
    public void delete(Integer id);
}
