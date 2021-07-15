package com.dragontalker.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dragontalker.beans.Employee;

/**
 * Mapper接口
 * 
 * 基于MyBatis: 在Mapper接口中编写CRUD相关方法 提供Mapper接口所对应的SQL映射文件以及方法对应的SQL语句
 * 
 * 基于MyBatisPlus: 让XxxMapper接口继承BaseMapper接口即可
 *                  BaseMapper<T>: 泛型指定的就是当前Mapper接口所操作的实体类类型
 */
public interface EmployeeMapper extends BaseMapper<Employee>{
	// Integer insertEmployee(Employee employee);
	// <insert userGeneratedKeys="true" keyProperty="id">SQL...</insert>
}
