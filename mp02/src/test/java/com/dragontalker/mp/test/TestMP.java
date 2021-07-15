package com.dragontalker.mp.test;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dragontalker.beans.Employee;

public class TestMP {
	
	private ApplicationContext ioc = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	/**
	 * AR 分页复杂操作
	 */
	@Test
	public void testARPage() {
		
		Employee employee = new Employee();
		
		Page<Employee> page = employee.selectPage(
					new Page<Employee>(1, 1),
					new EntityWrapper<Employee>()
						.like("last_name", "Sen")
				);
	}
	
	/**
	 * AR 删除操作
	 * 
	 * 注意: 删除不存在的数据在逻辑上也属于成功
	 */
	@Test
	public void testARDelete() {
		
		Employee employee = new Employee();
		//boolean result = employee.deleteById(2);
		//employee.setId(2);
		//boolean result = employee.deleteById();
		//System.out.println(">> result: " + result);
		
		boolean result = employee.delete(
					new EntityWrapper<Employee>()
						.like("last_name", "Xiao")
				);
		
		System.out.println(">> result: " + result);
	}
	
	/**
	 * AR 查询操作
	 */
	@Test
	public void testARSelect() {
		
		Employee employee = new Employee();
		
		//Employee result = employee.selectById(14);
		
		//employee.setId(14);
		//Employee result = employee.selectById();
		
		//System.out.println(">> result: " + result);
		
		//List<Employee> emps = employee.selectAll();
		
		//List<Employee> emps = employee.selectList(
					//new EntityWrapper<Employee>()
						//.like("last_name", "Sensei")
				//);
		
		//for (Employee emp : emps) {
			//System.out.println(">> result: " + emp);
		//}
		
		Integer result = employee.selectCount(
					new EntityWrapper<Employee>()
						.eq("gender", 0)
				);
		
		System.out.println(">> reuslt: " + result);
		
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
