package cn.smile.core;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/4
 */
@SpringBootApplication
public class MSpringBootConfiguration {
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(MSpringBootConfiguration.class);
		springApplication.setBannerMode(Banner.Mode.LOG);
		springApplication.run(args);
//		SpringApplication.run(MSpringBootConfiguration.class,args);
	}
}
