package com.dragontalker.mp.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
	 * 通用查询操作
	 */
	@Test
	public void testCommonSelect() {
		
		// 1. 通过id查询
		//Employee employee = employeeMapper.selectById(7);
		//System.out.println(employee);
		
		// 2. 通过多个列进行查询 id + lastName
		//Employee employee = new Employee();
		//employee.setId(7);
		//employee.setLastName("XiaoZeSensei");
		//employee.setGender(0);
		//Employee result = employeeMapper.selectOne(employee);
		
		// 3. 通过多个id进行查询 <foreach>
		List<Integer> idList = new ArrayList<>(); 
		idList.add(4);
		idList.add(5);
		idList.add(6);
		idList.add(7);
		
		List<Employee> emps = employeeMapper.selectBatchIds(idList);
		
		for (Employee emp : emps) {
			System.out.println(">> result: " + emp);
		}
	}
	
	/**
	 * 通用更新操作
	 */
	@Test
	public void testCommonUpdate() {
		
		// 初始化修改对象
		Employee employee = new Employee();
		employee.setId(7);
		employee.setLastName("XiaoZeSensei");
		employee.setEmail("xz@sina.com");
		employee.setGender(0);
		//employee.setAge(33);
		
		//Integer result = employeeMapper.updateById(employee);
		Integer result = employeeMapper.updateAllColumnById(employee);
		
		System.out.println(">> result: " + result);
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
