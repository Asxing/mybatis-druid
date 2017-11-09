package com.holddie.mybatisdruid.entity;

import com.holddie.mybatisdruid.enums.UserSexEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/8 22:16
 */
@Data
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String userName;

    private String passWord;

    private UserSexEnum userSex;

    private String nickName;

    public UserEntity() {
    }

    public UserEntity(Long id, String userName, String passWord, UserSexEnum userSex, String nickName) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
        this.nickName = nickName;
    }

    public UserEntity(String userName, String passWord, UserSexEnum userSex) {
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
    }
}
