package com.xmedia.springstart.response.Skill;

import com.xmedia.springstart.model.Skill;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class SkillResponseObject extends BaseResponse {

    private Skill skill;


    public SkillResponseObject() {

    }

    public SkillResponseObject(String message, int code, Skill skill) {
        super(message, code);
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}

