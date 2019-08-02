package com.xmedia.springstart.service.SkillEmployee;

import com.xmedia.springstart.model.Skill.SkillsEmployees;
import java.util.List;

public interface SkillEmployeeImpl {
    List<SkillsEmployees> getSkillEmployee();

    SkillsEmployees getId(int id);

    SkillsEmployees addSkillEmployee(SkillsEmployees model);

    void deleteSkillEmployee(int id, int idEmployee, int idSkill);

    void updateSkillEmployee(int id, int empId, SkillsEmployees model);

}
