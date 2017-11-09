package com.holddie.mybatisdruid.mapper.two;

import com.holddie.mybatisdruid.entity.UserEntity;
import com.holddie.mybatisdruid.enums.UserSexEnum;
import com.holddie.mybatisdruid.mapper.UserSql;
import com.holddie.mybatisdruid.param.UserParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 第二数据源Mapper接口
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/9 8:55
 */
public interface UserTwoMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @SelectProvider(type = UserSql.class, method = "getList")
    List<UserEntity> getList(UserParam userParam);

    @SelectProvider(type = UserSql.class, method = "getCount")
    int getCount(UserParam userParam);

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(UserEntity user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
