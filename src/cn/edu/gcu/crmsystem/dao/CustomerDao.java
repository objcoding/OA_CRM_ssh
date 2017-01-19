package cn.edu.gcu.crmsystem.dao;

import java.util.List;

import cn.edu.gcu.crmsystem.entity.Customer;

public interface CustomerDao {
	
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Customer> findAll();

}
