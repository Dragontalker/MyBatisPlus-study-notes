package com.dragontalker.mp.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dragontalker.mapper.EmployeeMapper;

public class TestMP {
	
	private ApplicationContext ioc = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private EmployeeMapper employeeMapper = 
			ioc.getBean("employeeMapper", EmployeeMapper.class);

	@Test
	public void testDataSource() throws Exception{
		
		DataSource ds = ioc.getBean("dataSource", DataSource.class);
		System.out.println(ds);
		
		Connection conn = ds.getConnection();
		System.out.println(conn);
		
	}

}
