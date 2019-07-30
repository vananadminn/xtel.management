package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSkillResponse extends BaseResponse {

    private String name;
    private int totalSkill;

    public EmployeeSkillResponse() {

    }

    public EmployeeSkillResponse(String message, int code, String name, int totalSkill) {
        this.setMessage(message);
        this.setCode(code);
        this.name = name;
        this.totalSkill = totalSkill;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalSkill() {
        return totalSkill;
    }

    public void setTotalSkill(int totalSkill) {
        this.totalSkill = totalSkill;
    }
}
