package com.xmedia.springstart.service.Employee;

import com.xmedia.springstart.data_query_model.SkillEmployee;
import com.xmedia.springstart.model.Employee.Employee;
import com.xmedia.springstart.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getListEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmpId(int empId) {
        return employeeRepository.findOne(empId);
    }

    @Override
    public Employee addEmp(Employee emp) {
        return employeeRepository.saveAndFlush(emp);
    }

    @Override
    public void deleteEmp(Integer empId) {
        employeeRepository.delete(empId);
    }

    @Override
    public void updateEmp(int empId, Employee emp) {
        employeeRepository.save(emp);
    }

    public String checkEmail(String email) {
        return employeeRepository.checkEmail(email);
    }

    public String checkId(int id) {
        return employeeRepository.checkId(id);
    }

    public String checkPhone(String phone) {
        return employeeRepository.checkPhone(phone);
    }

    public List<Employee> statusWorking() {
        return employeeRepository.statusWorking();
    }

    public List<Employee> statusNotWorking() {
        return employeeRepository.statusNotWorking();
    }

    public List<Employee> findNameEmployee(String name) {
        return employeeRepository.findAllByNameEquals(name);
    }

    public List<Employee> findAllByPositionsEquals(String name) {
        return employeeRepository.findAllByPositions(name);
    }

    public List<Employee> listEmployeeTime(Date createdDate, Date employeeDate) {
        return employeeRepository.listEmployeeTime(createdDate, employeeDate);
    }

    public List<Employee> findPositionEmployee(String name) {
        return employeeRepository.listEmployeePositions(name);
    }

    public List<Employee> findAmountEmployeeSkill(String name) {
        return employeeRepository.amountSkillEmployee(name);
    }

    public String checkEmployeeName(String name) {
        return employeeRepository.checkEmployeeName(name);
    }

    public String findSkillName(String name) {
        return employeeRepository.findSkillName(name);
    }

    public List<SkillEmployee> createSkillEmployee(int idEMployee, int idSkill, String createdBy) {
        return employeeRepository.createSkillEmployee(idEMployee, idSkill, createdBy);
    }

}
