package cn.smile.core.controller;

import ch.qos.logback.core.joran.action.AppenderRefAction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/8
 */
@Controller
public class LoginController {
	
	@PostMapping({"/user/login"})
	public String login(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password",
			required = false) String password, Model model, HttpServletRequest request) {
		if(StringUtils.isEmpty(username) && StringUtils.isEmpty(password)) {
			model.addAttribute("error","用户名或者密码不能为空");
			return "index";
		}
		else if (username.equals("admin") && password.equals("188")){
			HttpSession session = request.getSession();
			session.setAttribute("lastName","smile");
			return "redirect:/main.html";
		}
		else {
			model.addAttribute("error","密码或者用户名错误");
			return "index";
		}
	}
}
