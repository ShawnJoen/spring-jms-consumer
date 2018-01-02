package com.activemq.spring_jms_consumer;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Spring Jms Consumer演示 
 */
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    private static ClassPathXmlApplicationContext context;

    public static void main( String[] args ) {
    	
    	context = new ClassPathXmlApplicationContext(new String[] {"spring-context.xml"}); 
    	context.start();
    }
}