package com.holddie.mybatisdruid.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 多数据源配置
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2017/11/8 18:54
 */
@Configuration
public class MultiDataSourceConfig {

    @Primary
    @Bean(name = "oneDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.one")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "twoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.two")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

}
