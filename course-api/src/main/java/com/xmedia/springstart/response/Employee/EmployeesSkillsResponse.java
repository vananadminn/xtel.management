package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.data_query_model.Employee.EmployeeSkillList;

import java.util.List;

public class EmployeesSkillsResponse extends BaseResponse {
    private List<EmployeeSkillList> employeeSkillLists;

    public EmployeesSkillsResponse() {

    }

    public EmployeesSkillsResponse(String message, int code, List<EmployeeSkillList> employeeSkillLists) {
        super(message, code);
        this.employeeSkillLists = employeeSkillLists;
    }

    public List<EmployeeSkillList> getEmployeeSkillLists() {
        return employeeSkillLists;
    }

    public void setEmployeeSkillLists(List<EmployeeSkillList> employeeSkillLists) {
        this.employeeSkillLists = employeeSkillLists;
    }
}
