package com.holddie.mybatisdruid.web;

import com.holddie.mybatisdruid.entity.UserEntity;
import com.holddie.mybatisdruid.mapper.one.UserOneMapper;
import com.holddie.mybatisdruid.mapper.two.UserTwoMapper;
import com.holddie.mybatisdruid.param.UserParam;
import com.holddie.mybatisdruid.result.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 逻辑控制层
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/9 8:57
 */
@RestController
public class UserController {

    @Autowired
    private UserOneMapper userOneMapper;

    @Autowired
    private UserTwoMapper userTwoMapper;

    @RequestMapping(value = "/getUsers")
    public List<UserEntity> getUsers(){
        List<UserEntity> useronelist = userOneMapper.getAll();
        List<UserEntity> usertwolist = userTwoMapper.getAll();
        useronelist.addAll(usertwolist);
        return useronelist;
    };

    @RequestMapping(value = "/getList")
    public Page<UserEntity> getList(UserParam userParam){
        List<UserEntity> users = userOneMapper.getList(userParam);
        long count = userOneMapper.getCount(userParam);
        Page page = new Page(userParam,count,users);
        return page;
    }

    @RequestMapping(value = "/getUser")
    public UserEntity getUser(Long id){
        UserEntity userEntity = userOneMapper.getOne(id);
        return userEntity;
    }

    @RequestMapping(value = "/add")
    public void save(UserEntity userEntity){
        userOneMapper.insert(userEntity);
    }

    @RequestMapping(value = "/update")
    public void update(UserEntity userEntity){
        userOneMapper.update(userEntity);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userTwoMapper.delete(id);
    }
}
