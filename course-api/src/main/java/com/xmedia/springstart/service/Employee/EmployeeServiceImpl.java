package com.xmedia.springstart.service.Employee;

import com.xmedia.springstart.model.Employee.Employee;

import java.util.List;

public interface EmployeeServiceImpl {

    List<Employee> getListEmp();

    Employee getEmpId(int empId);

    Employee addEmp(Employee emp);

    void deleteEmp(Integer empId);

    void updateEmp(int empId, Employee emp);
}
