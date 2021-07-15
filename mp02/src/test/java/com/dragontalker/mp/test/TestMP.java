package com.dragontalker.mp.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dragontalker.beans.Employee;

public class TestMP {
	
	private ApplicationContext ioc = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	/**
	 * AR 查询操作
	 */
	@Test
	public void testARSelect() {
		
		Employee employee = new Employee();
		
		//Employee result = employee.selectById(14);
		
		employee.setId(14);
		Employee result = employee.selectById();
		
		System.out.println(">> result: " + result);

	}
	
	/**
	 * AR 修改操作
	 */
	@Test
	public void testARUpdate() {
		
		Employee employee = new Employee();
		employee.setId(14);
		employee.setLastName("SongLaoShi");
		employee.setEmail("sls@atguigu.com");
		employee.setGender(1);
		employee.setAge(36);
		
		boolean result = employee.updateById();
		System.out.println(">> result: " + result);
	}
	
	/**
	 * AR 插入操作
	 */
	@Test
	public void testARInsert() {
		
		Employee employee = new Employee();
		employee.setLastName("SongSensei");
		employee.setEmail("sls@atguigu.com");
		employee.setGender(1);
		employee.setAge(35);
		
		boolean result = employee.insert();
		System.out.println(">> result: " + result);
	}
	

	@Test
	public void testDataSource() throws Exception{
		
		DataSource ds = ioc.getBean("dataSource", DataSource.class);
		System.out.println(ds);
		
		Connection conn = ds.getConnection();
		System.out.println(conn);
		
	}

}
