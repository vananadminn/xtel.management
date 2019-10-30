package com.xmedia.springstart.data_query_model.Employee;

import java.io.Serializable;
import com.ligerdev.appbase.utils.db.AntTable;
import com.ligerdev.appbase.utils.db.AntColumn;


/*
	- 30/07/2019 11:20:16: Generated by sql
	select employees_id, skills_id from skills_employees
*/
@AntTable(catalog="xtel.management", name="SEResponse", label="SEResponse", key="")
public class SEResponse implements Serializable, Cloneable {

	private int id;
	private int employeesId;
	private int skillsId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SEResponse(){
	}
	
	public SEResponse(int employeesId, int skillsId){
		this();
		this.employeesId = employeesId;
		this.skillsId = skillsId;
	}
	
	@AntColumn(name="employees_id", size=11, label="employees_id")
	public void setEmployeesId(int employeesId){
		this.employeesId = employeesId;
	}
	
	@AntColumn(name="employees_id", size=11, label="employees_id")
	public int getEmployeesId(){
		return this.employeesId;
	}
	
	@AntColumn(name="skills_id", size=11, label="skills_id")
	public void setSkillsId(int skillsId){
		this.skillsId = skillsId;
	}
	
	@AntColumn(name="skills_id", size=11, label="skills_id")
	public int getSkillsId(){
		return this.skillsId;
	}
	
	@Override
	public String toString() {
		return "["
			+ "employeesId=" + employeesId
			+ ", skillsId=" + skillsId
			+ "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}