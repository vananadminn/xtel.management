package com.xmedia.springstart.repository;

//import com.xmedia.springstart.data_query_model.Employee.SEResponse;

import com.xmedia.springstart.model.Skill.SkillsEmployees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface SkillEmployeeRepository extends JpaRepository<SkillsEmployees, Integer> {
    /*check id employee*/
    @Query(value = "select se.employees_id from skills_employees se where se.employees_id = :id", nativeQuery = true)
    String findIdEmployee(@Param("id") int id);

    /*check id(primary key) of table skills_employees*/
    @Query(value = "select se.id from skills_employees se where se.id = :id", nativeQuery = true)
    String findIdSkillEmployee(@Param("id") int id);

    /*check id Skill of table skills_employees*/
    @Query(value = "select id from skill where id = :id ", nativeQuery = true)
    String findIdSkill(@Param("id") int id);

    /* delete skill of employee by id employee and id (primary key) table */
    @Modifying
    @Transactional
    @Query(value = "update skills_employees set skills_employees.skills_id = null where skills_employees.employees_id =?1 and skills_employees.id = ?2", nativeQuery = true)
    Integer deleteSkillEmployeeByIdEmployeeAndIdPrimary(long employeeId, long id);


}

