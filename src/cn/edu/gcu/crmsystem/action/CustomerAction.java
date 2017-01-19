package cn.edu.gcu.crmsystem.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.gcu.crmsystem.entity.Customer;
import cn.edu.gcu.crmsystem.service.CustomerService;

/**
 * 控制层
 * @author zch
 *
 */
@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport {
	
	CustomerService service = new CustomerService();
	
	/**
	 * 得到所有客户列表
	 * @return
	 */
	public String list() {
		
		List<Customer> list = service.findAll();
		
		//放到域对象里面
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		
		return "list";
	}
}
