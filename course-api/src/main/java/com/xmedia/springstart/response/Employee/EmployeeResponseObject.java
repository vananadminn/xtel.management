package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.model.Employee.Employee;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class EmployeeResponseObject extends BaseResponse {
    private Employee employee;

    public EmployeeResponseObject() {

    }

    public EmployeeResponseObject(String message, int code, Employee employee) {
        this.setMessage(message);
        this.setCode(code);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
