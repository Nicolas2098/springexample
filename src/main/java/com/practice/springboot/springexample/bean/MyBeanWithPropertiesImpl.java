package com.practice.springboot.springexample.bean;

public class MyBeanWithPropertiesImpl implements MyBeanWithProperties{
    private String name;
    private String surname;

    public MyBeanWithPropertiesImpl(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String function() {
        return name + "-" + surname;
    }
}
