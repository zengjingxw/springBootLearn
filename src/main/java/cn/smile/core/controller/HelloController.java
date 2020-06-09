package cn.smile.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/8
 */
@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String test() {
		return "hello";
	}
	
}
