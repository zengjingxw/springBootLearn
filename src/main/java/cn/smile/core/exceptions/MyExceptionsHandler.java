package cn.smile.core.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/9
 */
@ControllerAdvice
public class MyExceptionsHandler{
	
	//这种可以自定义异常处理,只是这种是没有自适应效果
//	@ResponseBody
//	@ExceptionHandler(value = {MyExceptions.class})
//	public Object handleExceptions(Exception e) {
//		Map<String ,Object> maps = new HashMap<>();
//		maps.put("code","user.not");
//		maps.put("meassage",e.getMessage());
//		return maps;
//	}
	
   //自定义异常数据，交给spring处理
	@ExceptionHandler(value = {MyExceptions.class})
	public String handleExceptions(Exception e, HttpServletRequest request) {
		Map<String ,Object> maps = new HashMap<>();
		request.setAttribute("javax.servlet.error.status_code",404);
		maps.put("code","user.not");
		maps.put("message",e.getMessage());
		request.setAttribute("ext",maps);
		return "forward:/error";
	}
}

