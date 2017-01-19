package cn.edu.gcu.crmsystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.edu.gcu.crmsystem.entity.Customer;
import cn.edu.gcu.crmsystem.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	/**
	 * 查找所有客户
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		//SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			/*//得到sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//得到session
			session = sessionFactory.openSession();*/
			
			/*
			 * 使用本地线程绑定的session
			 */
			session = HibernateUtils.getSessionobject();
			//开启事务
			tx = session.beginTransaction();
			
			//查询所有记录
			Criteria criteria = session.createCriteria(Customer.class);
			List<Customer> list = criteria.list();
			
			//提交事务
			tx.commit();
			return list;
		}catch(Exception e) {
			tx.rollback();
		}finally {
			//由于工具类只创建一个session,所以在项目中不需要关闭
			//session.close();
			//sessionFactory;
			//sessionFactory.close();
		}
		return null;
	}
}
