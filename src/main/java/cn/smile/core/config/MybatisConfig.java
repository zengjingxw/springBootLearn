package cn.smile.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/10
 */
@MapperScan(basePackages = { "cn.smile.core.mapper" })
@Configuration
public class MybatisConfig {
	
	
	//开启驼峰名称发
	@Bean
	public ConfigurationCustomizer configurationCustomizer() {
		ConfigurationCustomizer customizer = configuration -> {
			configuration.setMapUnderscoreToCamelCase(true);
		};
		return customizer;
	}
}
