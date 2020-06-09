package cn.smile.core.controller;

import cn.smile.core.exceptions.MyExceptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/8
 */
@Controller
public class SuccessController {
	
	@GetMapping("/success")
	public String success(Model model) {
		List<String> lists = new ArrayList<>();
		lists.add("李四");
		lists.add("张三");
		model.addAttribute("lists",lists);
		return "success";
	}
	
	@GetMapping(value = {"/","/index.html"})
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/testUser")
	public String test(@RequestParam("name") String name) {
		if(name.equals("aaa")) {
			throw new MyExceptions();
		}
		return "test";
	}
}
