package com.xmedia.springstart.response.Skill;

import com.xmedia.springstart.model.Skill;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkillResponseList extends BaseResponse {

    List<Skill> skill;

    public SkillResponseList() {

    }

    public SkillResponseList(List<Skill> skill) {
        this.skill = skill;
    }

    public SkillResponseList(String message, int code, List<Skill> skill) {
        super(message, code);
        this.skill = skill;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }
}
