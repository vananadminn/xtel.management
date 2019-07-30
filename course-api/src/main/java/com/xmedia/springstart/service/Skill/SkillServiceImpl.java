package com.xmedia.springstart.service.Skill;

import com.xmedia.springstart.model.Skill;
import java.util.List;

public interface SkillServiceImpl {

    List<Skill> getListSkill();

    Skill getSkillId(int id);

    Skill addSkill(Skill model);

    void deleteSkill(int id);

    void updateSkill(int id, Skill model);

}
