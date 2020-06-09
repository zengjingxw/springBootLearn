package cn.smile.core.components;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/9
 */
//给容器中加入自定定义的错误属性
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
	//返会页面能获取到的数据
	@Override
	public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
		errorAttributes.put("company","smile");
		//自定义异常处理器中的数据
		Map<String,Object> ext = (Map<String, Object>) requestAttributes.getAttribute("ext",0);
		errorAttributes.put("ext",ext);
		return errorAttributes;
	}
}
