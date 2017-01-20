package cn.edu.gcu.crmsystem.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.edu.gcu.crmsystem.entity.Customer;
import cn.edu.gcu.crmsystem.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	/**
	 * 查找所有客户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//得到sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//得到session
			session = sessionFactory.openSession();
			
			/*
			 * 使用本地线程绑定的session
			 >>>在正式项目才使用
			session = HibernateUtils.getSessionobject();*/
			
			
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
			//在使用本地线程绑定session时不用关闭
			session.close();
			//由于工具类只创建一个session,所以在项目中不需要关闭
			//sessionFactory.close();
		}
		return null;
	}
	
	public void add(){
		
	}
	
	/**
	 * 添加客户
	 */
	@Override
	public void addCustomer(Customer customer) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			//得到sessionFactory
			sessionFactory = HibernateUtils.getSessionFactory();
			//得到session
			session = sessionFactory.openSession();
			
			/*
			 * 使用本地线程绑定的session
			 >>>在正式项目才使用
			session = HibernateUtils.getSessionobject();*/
			
			
			//开启事务
			tx = session.beginTransaction();
			
			//添加
			Serializable id = session.save(customer);
			if(id != null){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
			
			//提交事务
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			//在使用本地线程绑定session时不用关闭
			session.close();
			//由于工具类只创建一个session,所以在项目中不需要关闭
			//sessionFactory.close();
		}
	}
}
