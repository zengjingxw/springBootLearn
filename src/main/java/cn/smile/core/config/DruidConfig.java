package cn.smile.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/10
 */
@Configuration
//@Profile(value = "dev")
public class DruidConfig {
	
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource dataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}
	
	
	//配置监控
	//1. 配置管理后台的Servlet
	//2. 配置监控的filter
	
	//配置管理控制台
	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		Map<String,String> maps= new HashMap<>();
		maps.put("loginUsername","admin");
		maps.put("loginPassword","123456");
		maps.put("allow","");
		maps.put("deny","192.168.43.217");
		servletRegistrationBean.setInitParameters(maps);
		return servletRegistrationBean;
	}
	
	//配置druid过滤器
	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		Map<String,String> maps= new HashMap<>();
		maps.put("exclusions","*.js,*.css,/druid/*");
		filterRegistrationBean.setInitParameters(maps);
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
		return filterRegistrationBean;
	}
}
