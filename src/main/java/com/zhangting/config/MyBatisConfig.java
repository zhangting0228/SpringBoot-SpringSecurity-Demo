package com.zhangting.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;


/**
 * @Author 张挺（zhangting@binfo-tech.com）
 * @Description Mybatis配置
 */
@Configuration
public class MyBatisConfig {

    @Bean({"dataSourceSqlSessionFactory"})
    public SqlSessionFactory dataSourceSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        return bean.getObject();
    }

    @Bean({"myMapperScannerConfigurer"})
    public MapperScannerConfigurer myMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("**.dao");
        configurer.setSqlSessionFactoryBeanName("dataSourceSqlSessionFactory");
        return configurer;
    }

    @Bean({"dataSourceSqlSessionTemplate"})
    public SqlSessionTemplate dataSourceSqlSessionTemplate(@Qualifier("dataSourceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return  new SqlSessionTemplate(sqlSessionFactory);
    }
}

