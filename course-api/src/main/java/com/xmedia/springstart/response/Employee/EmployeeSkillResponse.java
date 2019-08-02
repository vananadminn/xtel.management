package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.data_query_model.Employee.EmployeeSkill;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeSkillResponse extends BaseResponse {

    private List<EmployeeSkill> list;

    public EmployeeSkillResponse() {

    }

    public EmployeeSkillResponse(List<EmployeeSkill> list) {
        this.list = list;
    }

    public EmployeeSkillResponse(String message, int code, List<EmployeeSkill> list) {
        super(message, code);
        this.list = list;
    }

    public List<EmployeeSkill> getList() {
        return list;
    }

    public void setList(List<EmployeeSkill> list) {
        this.list = list;
    }
}
