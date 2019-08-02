package com.xmedia.springstart.response.Skill;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;

import java.util.List;

public class SkillEmployeeListResponse extends BaseResponse {

    private List<SkillEmployeeListResponse> listResponses;

    public SkillEmployeeListResponse() {

    }

    public SkillEmployeeListResponse(List<SkillEmployeeListResponse> listResponses) {
        this.listResponses = listResponses;
    }

    public SkillEmployeeListResponse(String message, int code, List<SkillEmployeeListResponse> listResponses) {
        super(message, code);
        this.listResponses = listResponses;
    }

    public List<SkillEmployeeListResponse> getListResponses() {
        return listResponses;
    }

    public void setListResponses(List<SkillEmployeeListResponse> listResponses) {
        this.listResponses = listResponses;
    }
}
