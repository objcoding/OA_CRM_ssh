package cn.edu.gcu.crmsystem.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.gcu.crmsystem.entity.Customer;
import cn.edu.gcu.crmsystem.service.CustomerService;

/**
 * 控制层
 * @author zch
 *
 */
@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	//依赖的业务逻辑层
	CustomerService service = new CustomerService();
	
	/*
	 * 把客户集合存放到值栈中
	 */
	private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}
	/**
	 * 得到所有客户列表
	 * @return
	 */
	public String list() {
		
		list = service.findAll();
		
//		//放到域对象里面
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("list", list);
		
		return "list";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String toAddPage(){
		return "toAddPage";
	}
	/**
	 * 添加客户
	 * @return
	 */
	public String addCustomer(){
		service.addCustomer(customer);
		return "addCustomer";
	}
	
	/**
	 * 使用模型驱动封装表单数据
	 * @return
	 */
	Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
}
