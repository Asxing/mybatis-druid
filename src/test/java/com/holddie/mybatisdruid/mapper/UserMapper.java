package com.holddie.mybatisdruid.mapper;

import com.holddie.mybatisdruid.entity.UserEntity;
import com.holddie.mybatisdruid.enums.UserSexEnum;
import com.holddie.mybatisdruid.mapper.one.UserOneMapper;
import com.holddie.mybatisdruid.mapper.two.UserTwoMapper;
import com.holddie.mybatisdruid.param.UserParam;
import com.holddie.mybatisdruid.result.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 插入数据
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/9 13:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapper {

    @Autowired
    private UserOneMapper userOneMapper;

    @Autowired
    private UserTwoMapper userTwoMapper;

    /**
     * 插入数据
     *
     * @author HoldDie
     * @email holddie@163.com
     * @date 2017/11/9 13:12
     * @param
     * @return
     */
    @Test
    public void testInsert(){
        userOneMapper.insert(new UserEntity("aaa","123456", UserSexEnum.MAN));
        userOneMapper.insert(new UserEntity("bbb","123456", UserSexEnum.WOMAN));
        userTwoMapper.insert(new UserEntity("ccc","123456", UserSexEnum.MAN));

        Assert.assertEquals(2,userOneMapper.getAll().size());
        Assert.assertEquals(2,userTwoMapper.getAll().size());
    }

    @Test
    public void testQuery(){
        List<UserEntity> users = userTwoMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate(){
        UserEntity userEntity = userOneMapper.getOne(28l);
        System.out.println(userEntity.toString());
        userEntity.setNickName("holddie");
        userOneMapper.update(userEntity);
        Assert.assertTrue("holddie".equals(userOneMapper.getOne(28l).getNickName()));
    }

    @Test
    public void testPage() {
        UserParam userParam = new UserParam();
        userParam.setUserSex("WOMAN");
        userParam.setCurrentPage(1);
        List<UserEntity> users = userOneMapper.getList(userParam);
        long count = userOneMapper.getCount(userParam);
        Page page = new Page(userParam,count,users);
        System.out.println(page);
    }


}
