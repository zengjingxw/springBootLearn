package cn.smile.core.components;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/**
 * 区域信息解析器
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/8
 */
public class MyLocaleResolver implements  LocaleResolver{
	//获取区域信息
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String l = request.getParameter("a");
		Locale locale = Locale.getDefault();
		if(!StringUtils.isEmpty(l)) {
			String[] s = l.split("_");
			locale = new Locale(s[0], s[1]);
		}
		
		return locale;
	}
	//设置区域信息
	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
	
	}
}
