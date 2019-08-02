package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.data_query_model.SkillEmployeeListExperienceModel;

import java.util.List;

public class EmployeeExperienceList extends BaseResponse {

    private List<SkillEmployeeListExperienceModel> listResponse;

    public EmployeeExperienceList() {

    }

    public EmployeeExperienceList(String message, int code, List<SkillEmployeeListExperienceModel> listResponse) {
        super(message, code);
        this.listResponse = listResponse;
    }

    public List<SkillEmployeeListExperienceModel> getListResponse() {
        return listResponse;
    }

    public void setListResponse(List<SkillEmployeeListExperienceModel> listResponse) {
        this.listResponse = listResponse;
    }
}
