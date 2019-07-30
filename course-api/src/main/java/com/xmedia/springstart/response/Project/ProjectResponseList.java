package com.xmedia.springstart.response.Project;

import com.xmedia.springstart.model.Project;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectResponseList extends BaseResponse {

    private List<Project> projectList;

    public ProjectResponseList() {

    }

    public ProjectResponseList(String message, int code, List<Project> projectList) {
        this.setMessage(message);
        this.setCode(code);
        this.projectList = projectList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
