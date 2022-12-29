package com.practice.springboot.springexample;

import com.practice.springboot.springexample.bean.MyBean;
import com.practice.springboot.springexample.bean.MyBeanWithDependency;
import com.practice.springboot.springexample.bean.MyBeanWithProperties;
import com.practice.springboot.springexample.component.ComponentDependency;
import com.practice.springboot.springexample.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringexampleApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(SpringexampleApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	public SpringexampleApplication(@Qualifier("componentTwoImp") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringexampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//componentDependency.saludar();
		//myBean.print();
		//myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println("-------User POJO----------");
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
		//LOGGER.error("Esto es un error de prueba");

	}
}
