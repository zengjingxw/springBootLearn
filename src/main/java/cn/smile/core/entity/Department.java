package cn.smile.core.entity;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/10
 */
public class Department {
	
	private Integer id;
	private String departmentName;
	
	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", departmentName='" + departmentName + '\'' +
				'}';
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
