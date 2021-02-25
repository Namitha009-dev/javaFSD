package com.namitha.training.spring_starter_pro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
//       #Load the xml config file
		ClassPathXmlApplicationContext theContext = new ClassPathXmlApplicationContext("applicationConfig.xml");

//		#2 fetch the bean from engineer container
         Engineer engineer= theContext.getBean("softwareEngineer", SoftwareEngineer.class);
         Engineer anotherEngineer=theContext.getBean("softwareEngineer", SoftwareEngineer.class);
         
         System.out.println(engineer==anotherEngineer);
//         #3 Call method on the bean object
         engineer.workForWages();
         //Singleton is default scope for a bean
	}
}
