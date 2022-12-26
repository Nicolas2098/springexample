package com.practice.springboot.springexample.bean;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int num = 1;
        System.out.println("");
        System.out.println(myOperation.suma(num));
        System.out.println("Hola desde la implemetacion de un bean con dep");
    }
}
