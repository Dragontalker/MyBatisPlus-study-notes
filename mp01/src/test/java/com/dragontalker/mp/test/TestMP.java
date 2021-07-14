package com.dragontalker.mp.test;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMP {
	
	private ApplicationContext ioc = 
			new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void testDataSource() {
		
		DataSource ds = ioc.getBean("dataSource", DataSource.class);
		System.out.println(ds);
	}

}
