package cn.smile.core.controller;

import cn.smile.core.dao.UserRepository;
import cn.smile.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/11
 */
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer uId) {
		User one = userRepository.findOne(uId);
		return one;
	}
	
	@GetMapping("/user")
	public User insertUser(User user) {
		User save = userRepository.save(user);
		return save;
	}
}
