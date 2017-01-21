package cn.edu.gcu.crmsystem.dao;

import java.util.List;

import cn.edu.gcu.crmsystem.entity.Customer;
import cn.edu.gcu.crmsystem.entity.User;

public interface CustomerDao {
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Customer> findAll();
	
	/**
	 * 添加客户
	 * @param customer
	 */
	void addCustomer(Customer customer);
	
	/**
	 * 查找用户
	 * @param user
	 */
	User findUser(User user);

}
