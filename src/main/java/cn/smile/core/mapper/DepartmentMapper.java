package cn.smile.core.mapper;

import cn.smile.core.entity.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/10
 */
@Repository
public interface DepartmentMapper {

	@Select("select * from department")
	public List<Department> getAllDepartment();
	
	@Select("select * from department where id = #{value}")
	public Department getDepartmentById(Integer id);
	
	@Insert("insert into department(id,departmentName) values(#{id},#{departmentName})")
	public Integer insert(Department department);
}
