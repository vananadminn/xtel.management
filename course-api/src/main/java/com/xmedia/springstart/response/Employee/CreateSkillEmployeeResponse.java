package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.model.Skill.SkillsEmployees;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateSkillEmployeeResponse extends BaseResponse {

    private SkillsEmployees skillEmployee;

    public CreateSkillEmployeeResponse() {

    }

    public CreateSkillEmployeeResponse(String message, int code, SkillsEmployees skillEmployee) {
        super(message, code);
        this.skillEmployee = skillEmployee;
    }

    public SkillsEmployees getSkillEmployee() {
        return skillEmployee;
    }

    public void setSkillEmployee(SkillsEmployees skillEmployee) {
        this.skillEmployee = skillEmployee;
    }
}
