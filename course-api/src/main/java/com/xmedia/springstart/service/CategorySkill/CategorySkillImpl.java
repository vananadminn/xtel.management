package com.xmedia.springstart.service.CategorySkill;

import com.xmedia.springstart.model.CategorySkill;

import java.awt.*;
import java.util.List;

public interface CategorySkillImpl {

    List<CategorySkill> getListSkill();

    CategorySkill getSkillId(int skillId);

    CategorySkill addSkill(CategorySkill skill);

    void deleteSkill(Integer skillId);

    void updateSkill(int skillId, CategorySkill skill);
}
