package com.practice.springboot.springexample.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImp implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Segunda implementacion del metodo saludar");
    }
}
