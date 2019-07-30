package com.xmedia.springstart.service.Project;

import com.xmedia.springstart.model.Project;
import com.xmedia.springstart.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements ProjectServiceImpl {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getListProject() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectId(int projectId) {
        return projectRepository.findOne(projectId);
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Integer projectId) {
        projectRepository.delete(projectId);
    }

    @Override
    public void updateProject(int projectId, Project project) {
        projectRepository.save(project);
    }


    public String findProjectName(String projectName) {
        return projectRepository.findName(projectName);
    }


    public String checkId(int id) {
        return projectRepository.checkId(id);
    }

}
