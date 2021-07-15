package com.dragontalker.mp.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dragontalker.beans.Employee;
import com.dragontalker.mapper.EmployeeMapper;

public class TestMP {
	
	private ApplicationContext ioc = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private EmployeeMapper employeeMapper = 
			ioc.getBean("employeeMapper", EmployeeMapper.class);
	
	/**
	 * 条件构造器 删除操作
	 */
	@Test
	public void testEnittyWrapperDelete() {
		
		employeeMapper.delete(
					new EntityWrapper<Employee>()
						.eq("last_name", "Tom")
						.eq("age", 22)
				);
		
	}
	

	@Test
	public void testDataSource() throws Exception{
		
		DataSource ds = ioc.getBean("dataSource", DataSource.class);
		System.out.println(ds);
		
		Connection conn = ds.getConnection();
		System.out.println(conn);
		
	}

}
