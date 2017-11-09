package com.holddie.mybatisdruid.mapper.one;

import com.holddie.mybatisdruid.entity.UserEntity;
import com.holddie.mybatisdruid.enums.UserSexEnum;
import com.holddie.mybatisdruid.mapper.UserSql;
import com.holddie.mybatisdruid.param.UserParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 第一数据源Mapper接口
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/8 22:23
 */
public interface UserOneMapper {

    @Select("select * from users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @SelectProvider(type = UserSql.class, method = "getList")
    List<UserEntity> getList(UserParam userParam);

    @SelectProvider(type = UserSql.class, method = "getCount")
    int getCount(UserParam userParam);

    @Select("select * from users where id = #{id} ")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("insert into users(userName,passWord,user_sex) values(#{userName},#{passWord},#{userSex})")
    void insert(UserEntity userEntity);

    @Update("update users set userName=#{userName},nick_name=#{nickName} where id = #{id}")
    void update(UserEntity userEntity);

    @Delete("delete from users where id = #{id}")
    void delete(Long id);
}
