package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.ResponseModel.SkillEmployee;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;

import java.util.List;

public class CreateSkillEmployeeResponse extends BaseResponse {

    private List<SkillEmployee> skillEmployeeList;

    public CreateSkillEmployeeResponse() {

    }

    public CreateSkillEmployeeResponse(String message, int code, List<SkillEmployee> skillEmployeeList) {
        super(message, code);
        this.skillEmployeeList = skillEmployeeList;
    }

    public List<SkillEmployee> getSkillEmployeeList() {
        return skillEmployeeList;
    }

    public void setSkillEmployeeList(List<SkillEmployee> skillEmployeeList) {
        this.skillEmployeeList = skillEmployeeList;
    }
}
