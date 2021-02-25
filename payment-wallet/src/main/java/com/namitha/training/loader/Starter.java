package com.namitha.training.loader;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.namitha.training.bean.Customer;
import com.namitha.training.ui.Main;

public class Starter {

	public static void main(String[] args) {
       
	    ClassPathXmlApplicationContext theContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//      reference the bean
	    Main theCustomer= theContext.getBean("main", Main.class);
	    theCustomer.getMenu();

	}

}
