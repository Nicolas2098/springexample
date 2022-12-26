package com.practice.springboot.springexample.bean;

public class MyBeanImpl implements MyBean{
    @Override
    public void print() {
        System.out.print("Hola desde MyBean");
    }
}
