package cn.smile.core.config;

import cn.smile.core.serlvet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/9
 */
@Configuration
public class MyServletConfig {
	
	//注册三大组件
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
		return servletRegistrationBean;
	}
}
