package com.practice.springboot.springexample;

import com.practice.springboot.springexample.bean.MyBean;
import com.practice.springboot.springexample.bean.MyBeanWithDependency;
import com.practice.springboot.springexample.bean.MyBeanWithProperties;
import com.practice.springboot.springexample.component.ComponentDependency;
import com.practice.springboot.springexample.component.SomeComponentDependency;
import com.practice.springboot.springexample.entity.User;
import com.practice.springboot.springexample.pojo.UserPojo;
import com.practice.springboot.springexample.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringexampleApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(SpringexampleApplication.class);

	private ComponentDependency componentDependency;
	private SomeComponentDependency someComponentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	private UserRepository userRepository;

	public SpringexampleApplication(@Qualifier("componentTwoImp") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository, SomeComponentDependency someComponentDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.someComponentDependency = someComponentDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringexampleApplication.class, args);
	}

	private void saveUserInDB(){
		User user1 = new User("Nicolas1","Nicolas1@mail.com", LocalDate.now());
		User user2 = new User("Nicolas2","Nicolas2@mail.com", LocalDate.now());
		User user3 = new User("Nicolas3","Nicolas3@mail.com", LocalDate.now());
		User user4 = new User("Nicolas4","Nicolas4@mail.com", LocalDate.now());
		User user5 = new User("Nicolas5","Nicolas4@mail.com", LocalDate.now());

/*		try {
			this.someComponentDependency.SomeComponent(DataSourceBuilder.create().build());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
*/
		List<User> users = Arrays.asList(user1,user2,user3,user4,user5);
		try {
			users.stream().forEach(userRepository::save);
		}catch (RuntimeException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run(String... args) throws Exception {
		saveUserInDB();
	}

	//componentDependency.saludar();
	//myBean.print();
	//myBeanWithDependency.printWithDependency();
	//System.out.println(myBeanWithProperties.function());
	//System.out.println("-------User POJO----------");
	//System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
	//LOGGER.error("Esto es un error de prueba");
}
