package com.zhangting.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author 张挺（zhangting@binfo-tech.com）
 * @Description 数据源配置 - mysql
 */
@Configuration
public class MyDataSourceconfig {

    public MyDataSourceconfig() {
    }

    @Bean({"mysqlDataSource"})
    @ConfigurationProperties(
            prefix = "spring.datasource.mysql"
    )
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
