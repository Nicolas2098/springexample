package com.practice.springboot.springexample;

import com.practice.springboot.springexample.bean.MyBean;
import com.practice.springboot.springexample.bean.MyBeanWithDependency;
import com.practice.springboot.springexample.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringexampleApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	public SpringexampleApplication(@Qualifier("componentTwoImp") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringexampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
	}
}
