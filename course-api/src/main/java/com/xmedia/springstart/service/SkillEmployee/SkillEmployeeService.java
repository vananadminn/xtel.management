package com.xmedia.springstart.service.SkillEmployee;

import com.xmedia.springstart.model.Skill.SkillsEmployees;
import com.xmedia.springstart.repository.SkillEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillEmployeeService implements SkillEmployeeImpl {

    @Autowired
    private SkillEmployeeRepository skillEmployeeRepository;

    @Override
    public List<SkillsEmployees> getSkillEmployee() {
        return skillEmployeeRepository.findAll();
    }

    @Override
    public SkillsEmployees getId(int id) {
        return skillEmployeeRepository.findOne(id);
    }

    @Override
    public SkillsEmployees addSkillEmployee(SkillsEmployees model) {
        return skillEmployeeRepository.save(model);
    }

    @Override
    public void deleteSkillEmployee(int id, int idEmployee, int idSkill) {
        skillEmployeeRepository.delete(id);
    }

    @Override
    public void updateSkillEmployee(int id, int empId, SkillsEmployees model) {
        skillEmployeeRepository.save(model);
    }

    public String findIdEmployee(int id) {
        return skillEmployeeRepository.findIdEmployee(id);
    }

    public String findIdSkillEmployee(int id) {
        return skillEmployeeRepository.findIdSkillEmployee(id);
    }

    public String findIdSkill(int id) {
        return skillEmployeeRepository.findIdSkill(id);
    }

    public Integer deleteSkillEmployeeByIdEmployeeAndIdPrimary(long idEmployee, long id) {
        return skillEmployeeRepository.deleteSkillEmployeeByIdEmployeeAndIdPrimary(idEmployee, id);
    }
}

