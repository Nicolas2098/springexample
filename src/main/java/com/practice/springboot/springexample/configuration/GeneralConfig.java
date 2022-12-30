package com.practice.springboot.springexample.configuration;

import com.practice.springboot.springexample.bean.MyBeanWithProperties;
import com.practice.springboot.springexample.bean.MyBeanWithPropertiesImpl;
import com.practice.springboot.springexample.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfig {
    @Value("${value.name}")
    private String name;

    @Value("${value.surname}")
    private String surname;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImpl(name,surname);
    }

    /*@Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/springexample");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("sinPass1");
        return dataSourceBuilder.build();
    }*/
}