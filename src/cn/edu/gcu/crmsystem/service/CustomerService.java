package cn.edu.gcu.crmsystem.service;

import java.util.List;

import cn.edu.gcu.crmsystem.dao.CustomerDao;
import cn.edu.gcu.crmsystem.dao.CustomerDaoImpl;
import cn.edu.gcu.crmsystem.entity.Customer;
import cn.edu.gcu.crmsystem.entity.User;
import cn.edu.gcu.crmsystem.entity.UserException;

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
	
	/**
	 * 查找客户
	 * @param user
	 * @return
	 */
	public User findUser(User user) throws UserException {
		User _user = dao.findUser(user);
		if (_user == null) {
			throw new UserException("用户不存在");
		}else {
			return _user;
		}
	}
}
