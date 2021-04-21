package com.ladybug.service;

import com.ladybug.dao.PersonMapper;
import com.ladybug.dao.UserMapper;
import com.ladybug.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper mapper;
    @Override
    public User login(String username, String password) {
        User user=mapper.login(username,password);
        return user;
    }

    @Override
    public List<User> select() {
        List<User> list=mapper.select();
        return list;
    }

    @Override
    public void add(User user) {
        mapper.add(user);
    }

    @Override
    public User find(Integer id) {
        User user=mapper.find(id);
        return user;
    }

    @Override
    public void update(User user) {
        mapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }
}
