package cn.edu.gcu.crmsystem.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate实用工具类
 * @author zch
 *
 */
public class HibernateUtils {

	static Configuration cfg = null;
	static SessionFactory sessionFactory = null;
	//静态代码块
	static {
		//加载核心配置文件
		cfg = new Configuration();
		cfg.configure();
		//只创建个sessionFactory
		sessionFactory = cfg.buildSessionFactory();
	}
	
	/**
	 * 返回与本地线程绑定的session
	 * @return
	 */
	public static Session getSessionobject() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 返回sessionFactory
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
/*	public static void main(String[] args) {
		getSessionFactory();
	}*/
}
