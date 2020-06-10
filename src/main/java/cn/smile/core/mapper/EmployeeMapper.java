package cn.smile.core.mapper;

import cn.smile.core.entity.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/10
 */


public interface EmployeeMapper {
	
	@Select("select * from employee")
	public List<Employee> getAllEmployee();
	
	@Select("select * from employee where id = #{value}")
	public Employee getEmployeeById(Integer id);
}
