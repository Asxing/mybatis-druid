package com.holddie.mybatisdruid.param;

import lombok.Data;

/**
 * 用户查询Bean
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/8 22:27
 */
@Data
public class UserParam extends PageParam {

    private String userName;

    private String userSex;
}
