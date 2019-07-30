package com.xmedia.springstart.repository;

import com.xmedia.springstart.ResponseModel.SkillEmployee;
import com.xmedia.springstart.model.Employee;
import com.xmedia.springstart.response.Employee.EmployeeExperienceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /* check email status (exits, not exits) on database */
    @Query("SELECT e.email FROM Employee e WHERE e.email=?1 ")
    String checkEmail(String email);

    /* check id status (exits, not exits) on database */
    @Query("SELECT e.id FROM Employee e WHERE e.id=?1")
    String checkId(int id);

    /* check phone number status (exits, not exits) on database */
    @Query("SELECT e.phone FROM Employee e WHERE e.phone=?1")
    String checkPhone(String phone);

    /* Show list employee with the working status on database */
    @Query("SELECT e.name, e.phone, e.email, e.startDate, e.employeeDate, e.createdBy FROM Employee e WHERE e.status =true")
    List<Employee> statusWorking();

    /*  Show list employee with the not working status on database*/
    @Query("SELECT e.name, e.phone, e.email, e.startDate, e.employeeDate, e.createdBy FROM Employee e WHERE e.status =false")
    List<Employee> statusNotWorking();

    /*return list employee by name of employee*/
    List<Employee> findAllByNameEquals(String name);

    /*return list employee by position of employee*/
    @Query("SELECT e FROM Employee e LEFT JOIN Position p WHERE p.name = :positionName")
    List<Employee> findAllByPositions(@Param("positionName") String name);

    /**
     * return an employee list in start date to end date
     */
    @Query("SELECT e.name, e.phone, e.email, e.startDate, e.employeeDate, e.createdBy FROM Employee e WHERE e.startDate >= :createdDate and e.employeeDate <= :employeeDate")
    List<Employee> listEmployeeTime(@Param("createdDate") Date createdDate, @Param("employeeDate") Date employeeDate);

    /**
     * return an employee by position
     */
    @Query(value = "select e.* from employee e join employee_position ep on e.id = ep.employee_id join position p on  p.id = ep.position_id where p.name = :name", nativeQuery = true)
    List<Employee> listEmployeePositions(@Param("name") String name);

    /*
    return total skill of an employee
     */
    @Query(value = "select e.* FROM employee e join skills_employees se on e.id = se.employees_id join skill s on se.skills_id = s.id where e.name =:name", nativeQuery = true)
    List<Employee> amountSkillEmployee(@Param("name") String name);

    /* search an employee if exist param vlue
     * */
    @Query(value = "select e.name from employee e where e.name = :name", nativeQuery = true)
    String checkEmployeeName(@Param("name") String name);

    /*return list experience of an employee*/
    @Query(value = "select ee.employee_id as id , e.name as name , e.email as email, s.name as skillName, ex.start as start, ex.now as now FROM employee e join employee_experience ee on e.id = ee.employee_id join experience ex on ex.id = ee.experience_id join skill s on s.id = ee.skills_id where s.name = :name", nativeQuery = true)
    List<EmployeeExperienceResponse> experienceEmployee(@Param("name") String name);

    /*return an skill name if variable param is exists param value*/
    @Query(value = "select s.name from Skill s where s.name = :name", nativeQuery = true)
    String findSkillName(@Param("name") String name);

    /*add new skill for employee*/
    @Query(value = "insert into skills_employees(employees_id, skills_id, created_by) values (?1, ?2, ?3)", nativeQuery = true)
    List<SkillEmployee> createSkillEmployee(@Param("idEmployee") int idEmployee, @Param("idSkill") int idSkill, @Param("createdBy") String createdBy);

}
