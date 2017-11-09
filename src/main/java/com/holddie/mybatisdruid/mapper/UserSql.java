package com.holddie.mybatisdruid.mapper;

import com.holddie.mybatisdruid.param.UserParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provider 查询支持类
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/9 8:31
 */
public class UserSql {
    public static final Logger log = LoggerFactory.getLogger(UserSql.class);

    public String getList(UserParam userParam){
        int currentPage = 1;
        int pageSize =15;
        StringBuffer sql = new StringBuffer("select id, userName, passWord, user_sex as userSex, nick_name as nickName");
        sql.append(" from users where 1=1 ");
        if (userParam != null){
            if (!StringUtils.isBlank(userParam.getUserName())){
                sql.append(" and userName = #{userName} ");
            }
            if (!StringUtils.isBlank(userParam.getUserSex())){
                sql.append(" and user_sex = #{userSex} ");
            }
        }
        sql.append(" order by id desc ");
        sql.append(" limit " + userParam.getBeginLine() + "," + userParam.getPageSize());
        log.info("getList sql is :" + sql.toString());
        return sql.toString();
    }

    public String getCount(UserParam userParam){
        String sql = new SQL(){{
            SELECT("count(1)");
            FROM("users");
            if (StringUtils.isNoneBlank(userParam.getUserName())){
                WHERE("userName = #{userName}");
            }
            if (StringUtils.isNoneBlank(userParam.getUserSex())){
                WHERE("user_sex = #{userSex}");
            }
        }}.toString();
        log.info("getCount sql is :" + sql);
        return sql;
    }
}
