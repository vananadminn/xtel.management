package com.xmedia.springstart.service.Skill;

import com.xmedia.springstart.model.Skill.Skill;
import com.xmedia.springstart.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService implements SkillServiceImpl {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> getListSkill() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillId(int id) {
        return skillRepository.findOne(id);
    }

    @Override
    public Skill addSkill(Skill model) {
        return skillRepository.save(model);
    }

    @Override
    public void deleteSkill(int id) {
        skillRepository.delete(id);
    }

    @Override
    public void updateSkill(int id, Skill model) {
        skillRepository.save(model);
    }

    public String findSkillName(String name) {
        return skillRepository.findSkillName(name);
    }

    public String findSkillId(int id) {
        return skillRepository.findSkillId(id);
    }

    public List<Skill> searchSkillByName(String name) {
        return skillRepository.listSkill(name);
    }
}
