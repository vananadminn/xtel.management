package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.model.Employee;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeResponseList extends BaseResponse {

    List<Employee> employees;

    public EmployeeResponseList() {
    }

    public EmployeeResponseList(String message, int code, List<Employee> list) {
        this.setMessage(message);
        this.setCode(code);
        this.employees = list;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
