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
	/**
	 * 查找所有客户
	 * @return
	 */
	public List<Customer> findAll() {
		CustomerDao dao = new CustomerDaoImpl();
		return dao.findAll();
	}

}
