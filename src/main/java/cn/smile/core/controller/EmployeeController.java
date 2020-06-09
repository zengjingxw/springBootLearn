package cn.smile.core.controller;

import cn.smile.core.dao.DepartmentDao;
import cn.smile.core.dao.EmployeeDao;
import cn.smile.core.entities.Department;
import cn.smile.core.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/8
 */
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	
	
	//显示员工列表
	@GetMapping("/emps")
	public String list(Model model) {
		Collection<Employee> all = employeeDao.getAll();
		model.addAttribute("userLists", all);
		return "emp/list";
	}
	
	//跳转员工的登录页面
	@GetMapping("/emp")
	public String add(Model model) {
		Collection<Department> d = departmentDao.getDepartments();
		model.addAttribute("depts",d);
		return "emp/add";
	}
	
	@PostMapping("/emp")
	public String save(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@GetMapping("/emp/{id}")
	public String toUpd(@PathVariable(value = "id") Integer id, Model model) {
		Employee employee = employeeDao.get(id);
		model.addAttribute("emp",employee);
		Collection<Department> d = departmentDao.getDepartments();
		model.addAttribute("depts",d);
		return "emp/add";
	}
	
	@PutMapping("/emp")
	public String put(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@DeleteMapping("/emp/{id}")
	public String delete(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}
