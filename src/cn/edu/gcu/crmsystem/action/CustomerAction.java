package cn.edu.gcu.crmsystem.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.gcu.crmsystem.entity.User;
import cn.edu.gcu.crmsystem.entity.UserException;
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
	
	/**
	 * 得到所有客户列表
	 * @return
	 */
	private List<Customer> list;//把客户集合存放到值栈中
	public List<Customer> getList() {
		return list;
	}
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
	Customer customer = new Customer();//使用模型驱动封装表单数据
	@Override
	public Customer getModel() {
		return customer;
	}
	public String addCustomer(){
		service.addCustomer(customer);
		return "addCustomer";
	}
	
	/**
	 * 登录
	 * @return
	 */
	User user = new User();//使用表达式封装表单数据
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String login(){
		try{
		User _user = service.findUser(user);
		ServletActionContext.getRequest().getSession().setAttribute("user", _user);
		return "loginsuccess";
		} catch (UserException e) {
			ServletActionContext.getRequest().setAttribute("msg", e.getMessage());
			return "login";
		}
	}
}
