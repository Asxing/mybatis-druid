package com.holddie.mybatisdruid.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Session 配置
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/19 21:45
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {

}
