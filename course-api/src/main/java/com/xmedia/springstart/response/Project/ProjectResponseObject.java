package com.xmedia.springstart.response.Project;

import com.xmedia.springstart.model.Project;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectResponseObject extends BaseResponse {

    private Project project;

    public ProjectResponseObject() {

    }

    public ProjectResponseObject(String message, int code, Project project) {
        this.setMessage(message);
        this.setCode(code);
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
