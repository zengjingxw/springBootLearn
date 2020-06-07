package cn.smile.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestM {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Test
	public void test() {
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
	}
	
}
