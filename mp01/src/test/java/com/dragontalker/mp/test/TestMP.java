package com.dragontalker.mp.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dragontalker.beans.Employee;
import com.dragontalker.mapper.EmployeeMapper;

public class TestMP {
	
	private ApplicationContext ioc = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private EmployeeMapper employeeMapper = 
			ioc.getBean("employeeMapper", EmployeeMapper.class);
	
	/**
	 * 通用更新操作
	 */
	@Test
	public void testCommonUpdate() {
		
		// 初始化修改对象
		Employee employee = new Employee();
		employee.setId(5);
		employee.setLastName("MyBatisPlus");
		employee.setEmail("mybatisPlus@sina.com");
		employee.setGender(0);
		employee.setAge(33);
		
		employeeMapper.updateById(employee);
	}
	
	/**
	 * 通用插入操作
	 */
	@Test
	public void testCommonInsert() {
		
		// 初始化Employee对象
		Employee employee = new Employee();
		employee.setLastName("MP");
		employee.setEmail("mp@atguigu.com");
		//employee.setGender(1);
		//employee.setAge(22);
		employee.setSalary(20000.0);
		
		// 插入到数据库
		// insert方法在插入时, 会根据实体类的每个属性进行非空判断, 只有非空属性对应的字段的才会出现到SQL语句中
		//Integer result = employeeMapper.insert(employee);
		
		// insertAllColumns方法在插入时, 不管属性是否非空, 属性对应的字段都会出现到SQL语句中
		Integer result = employeeMapper.insertAllColumn(employee);
		
		System.out.println(">> reuslt " + result);
		
		// 获取当前数据在数据库中的主键值
		Integer key = employee.getId();
		System.out.println(">> key: " + key);
	}

	@Test
	public void testDataSource() throws Exception{
		
		DataSource ds = ioc.getBean("dataSource", DataSource.class);
		System.out.println(ds);
		
		Connection conn = ds.getConnection();
		System.out.println(conn);
		
	}

}
