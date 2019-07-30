package com.xmedia.springstart.service.Project;

import com.xmedia.springstart.model.Project;

import java.util.List;

public interface ProjectServiceImpl {

    List<Project> getListProject();

    Project getProjectId(int projectId);

    Project addProject(Project project);

    void deleteProject(Integer projectId);

    void updateProject(int projectId, Project project);

}
