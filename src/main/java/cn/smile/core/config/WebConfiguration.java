package cn.smile.core.config;

import cn.smile.core.components.MyLocaleResolver;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/8
 */
/*
*  在spring高版本中 WebMvcConfigurerAdapter 已经废弃,可以直接实现  WebMvcConfigurer
* */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public EmbeddedServletContainerCustomizer customizer() {
		//定制嵌入式Servlet容器的相关规则
		EmbeddedServletContainerCustomizer customizer = (ConfigurableEmbeddedServletContainer container) -> {
			container.setPort(8083);
		};
		return customizer;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//设置静态资源直接映射,urlPath: 访问路径,ViewName:success视图名称，这是有视图解析器解析的
		registry.addViewController("/smile").setViewName("success");
	}
	
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("index");
				registry.addViewController("/index.html").setViewName("index");
				registry.addViewController("/main.html").setViewName("dashboard");
			}
			
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
//				registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
			}
		};

		return webMvcConfigurerAdapter;
	}
	
	@Bean
	public LocaleResolver localeResolver () {
		return new MyLocaleResolver();
	}
}
