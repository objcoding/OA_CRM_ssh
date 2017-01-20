package cn.edu.gcu.crmsystem.service;

import java.util.List;

import cn.edu.gcu.crmsystem.dao.CustomerDao;
import cn.edu.gcu.crmsystem.dao.CustomerDaoImpl;
import cn.edu.gcu.crmsystem.entity.Customer;
/**
 * 业务逻辑层
 * @author zch
 *
 */
public class CustomerService {
	
	CustomerDao dao = new CustomerDaoImpl();
	
	/**
	 * 查找所有客户
	 * @return
	 */
	public List<Customer> findAll() {
		return dao.findAll();
	}
	
	/**
	 * 添加客户
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
	}

}
