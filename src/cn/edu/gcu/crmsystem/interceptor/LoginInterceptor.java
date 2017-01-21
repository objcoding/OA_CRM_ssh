package cn.edu.gcu.crmsystem.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object user = session.getAttribute("user");
		
		if (user != null) {//登录
			//类似过滤器的放行
			return invocation.invoke();
		}else {//没登录
			return "login";
		}
	}
}
