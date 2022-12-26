package com.practice.springboot.springexample.configuration;

import com.practice.springboot.springexample.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfiguration {

    @Bean
    public MyBean beanOperation(){
        return new MyBean2Impl();
    }

    @Bean
    public MyOperation beanOperation2(){
        return new MyOperationImpl();
    }

    @Bean
    public MyBeanWithDependency beanOperationImpl(MyOperation myOperation){
        return new MyBeanWithDependencyImpl(myOperation);
    }
}
