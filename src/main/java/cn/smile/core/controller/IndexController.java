package cn.smile.core.controller;

import cn.smile.core.entity.Department;
import cn.smile.core.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/10
 */
@RestController
public class IndexController {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@GetMapping("/add")
	public Object add(Department department) {
	 	departmentMapper.insert(department);
		return department;
	}
	
	@GetMapping("/find")
	public Object getAll() {
		List<Department> allDepartment = departmentMapper.getAllDepartment();
		return allDepartment;
	}
	
	@GetMapping("/findById/{id}")
	public Object getDepartmentById(@PathVariable("id") Integer id) {
		Department departmentById = departmentMapper.getDepartmentById(id);
		return departmentById;
	}
}
