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
public class DruidConfig {
	
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource dataSource() {
		return new DruidDataSource();
	}
	
	@Bean
	public ServletRegistrationBean startViewServlet() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		return bean;
	}
	
	@Bean
	public FilterRegistrationBean startFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
		Map<String, String> maps = new HashMap<>();
		maps.put("exclusions","*.js,*.css,/druid/*");
		filterRegistrationBean.setInitParameters(maps);
		return filterRegistrationBean;
	}
}
