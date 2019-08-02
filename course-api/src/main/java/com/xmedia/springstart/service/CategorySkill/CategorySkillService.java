package com.xmedia.springstart.service.CategorySkill;

import com.xmedia.springstart.model.CategorySkill.CategorySkill;
import com.xmedia.springstart.repository.CategorySkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySkillService implements CategorySkillImpl {

    @Autowired
    CategorySkillRepository categorySkillRepository;

    @Override
    public List<CategorySkill> getListSkill() {
        return categorySkillRepository.findAll();
    }

    @Override
    public CategorySkill getSkillId(int skillId) {
        return categorySkillRepository.findOne(skillId);
    }

    @Override
    public CategorySkill addSkill(CategorySkill skill) {
        return categorySkillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Integer skillId) {
        categorySkillRepository.delete(skillId);
    }

    @Override
    public void updateSkill(int skillId, CategorySkill skill) {
        categorySkillRepository.save(skill);
    }

    public Integer checkId(int id) {
        return categorySkillRepository.checkId(id);
    }

}
