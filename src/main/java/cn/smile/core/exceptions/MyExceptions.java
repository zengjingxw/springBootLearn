package cn.smile.core.exceptions;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/9
 */
public class MyExceptions extends RuntimeException {

	public MyExceptions() {
		super("用户名不存在");
	}
}
