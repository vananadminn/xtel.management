package com.xmedia.springstart.response.Skill;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.data_query_model.SeResponse;
import org.springframework.stereotype.Component;

@Component
public class SkillEmployeeResponse extends BaseResponse {
    private SeResponse employee;

    public SkillEmployeeResponse() {

    }

    public SkillEmployeeResponse(String message, int code, SeResponse employee) {
        this.setMessage(message);
        this.setCode(code);
        this.employee = employee;
    }

    public SeResponse getEmployee() {
        return employee;
    }

    public void setEmployee(SeResponse employee) {
        this.employee = employee;
    }
}
