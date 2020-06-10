package cn.smile.core.entity;

/**
 * @author smiletofotget
 * @creationTime 2020-06-2020/6/10
 */
public class Employee {
	
	private Integer id;
	private String lsatName;
	private String email;
	private Integer gender;
	private Integer dId;
	
	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lsatName='" + lsatName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", dId=" + dId +
				'}';
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLsatName() {
		return lsatName;
	}
	
	public void setLsatName(String lsatName) {
		this.lsatName = lsatName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getGender() {
		return gender;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	public Integer getdId() {
		return dId;
	}
	
	public void setdId(Integer dId) {
		this.dId = dId;
	}
}
