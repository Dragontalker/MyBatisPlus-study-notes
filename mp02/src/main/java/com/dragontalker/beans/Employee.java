package com.dragontalker.beans;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

/**
 * JavaBean
 * 
 * 定义JavaBean时, 成员变量所使用的类型:
 *   因为每个基本类型都有一个默认值:
 *     int ==> 0
 *     boolean ==> false
 */

/**
 * MyBatisPlus会默认使用实体类的类名到数据中找对应的表
 */
public class Employee extends Model<Employee>{

	private static final long serialVersionUID = -3452447172643644354L;

	private Integer id;
	
	@TableField(value = "last_name")
	private String lastName;
	
	private String email;
	
	private Integer gender;
	
	private Integer age;
	
	@TableField(exist = false)
	private Double salary;
	
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getGender() {
		return gender;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", age="
				+ age + ", salary=" + salary + "]";
	}

	/**
	 * 指定当前类的主键属性
	 */
	@Override
	protected Serializable pkVal() {
		return id;
	}
	
}
