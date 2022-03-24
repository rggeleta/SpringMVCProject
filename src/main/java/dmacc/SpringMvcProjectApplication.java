package dmacc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import dmacc.controller.BeanConfiguration;
import dmacc.model.CampusAddress;
import dmacc.model.Student;
import dmacc.reposittory.StudentsRepository;

@SpringBootApplication
public class SpringMvcProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
		
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Student s = appContext.getBean("student", Student.class);
		System.out.println(s.toString());
		
		
	}

	@Autowired
	StudentsRepository repo;

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		//Using an existing bean
		Student s = appContext.getBean("student", Student.class);
		s.setMajor("Computer Science");
		repo.save(s);
		
		//Create a bean to use - not managed by Spring
		Student d = new Student("Sandra Boyton", "555-555-5556", "computerScience");
		CampusAddress ca = new CampusAddress("987 Elm Court", "Altoona", "IA");
		d.setCampusAddress(ca);
		repo.save(d);
		
	   java.util.List<Student> allMyStudents = repo.findAll();
		for(Student people: allMyStudents) {
			System.out.println(people.toString());
		}
		
		//closes the ApplicationContext resource leak - not imperative to add but nice to clean it up
		((AbstractApplicationContext) appContext).close();
	
	}

}