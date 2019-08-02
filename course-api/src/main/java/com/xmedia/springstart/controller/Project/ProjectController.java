package com.xmedia.springstart.controller.Project;


import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.response.BaseResponse.CodeResponse;
import com.xmedia.springstart.response.Project.ProjectResponseList;
import com.xmedia.springstart.response.Project.ProjectResponseObject;
import com.xmedia.springstart.model.Project.Project;
import com.xmedia.springstart.service.Customer.CustomerService;
import com.xmedia.springstart.service.Project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("api/project")
public class ProjectController extends CodeResponse {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private BaseResponse baseResponse;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProjectResponseList projectResponseList;


    @GetMapping("read")
    @ResponseBody
    public BaseResponse readAllProject() {
        List<Project> projectList = projectService.getListProject();
        int count = projectList.size();
        if (count == 0) {
            return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
        } else {
            return new ProjectResponseList(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, projectList);
        }
    }

    @PostMapping("create")
    @ResponseBody
    public BaseResponse addProject(@RequestBody Project project) {
        if (projectService.findProjectName(project.getName()) != null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_NAME + project.getName(), this.CODE_DUPLICATE_NAME);
            return baseResponse;
        } else if (customerService.checkId(project.getCustomersId()) == null) {
            baseResponse = new BaseResponse(this.GET_ID_CUSTOMER_NOT_EXITS + project.getCustomersId(), this.CODE_DUPLICATE_ID_CUSTOMER);
            return baseResponse;
        } else {
            try {
                projectService.addProject(setModel(project));
                return new ProjectResponseObject(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, project);
            } catch (Exception e) {
                return new BaseResponse(this.GET_ADD_FAIL, this.CODE_ADD_FAIL);
            }
        }
    }

    @PostMapping(value = "update/{id}")
    @ResponseBody
    public BaseResponse updateProject(@PathVariable("id") int id, @RequestBody Project project) {
        if (projectService.checkId(id) == null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_ID + id, this.CODE_DUPLICATE_ID);
            return baseResponse;
        } else if (customerService.checkId(project.getCustomersId()) == null) {
            baseResponse = new BaseResponse(this.GET_ID_CUSTOMER_NOT_EXITS + project.getCustomersId(), this.CODE_DUPLICATE_ID_CUSTOMER);
            return baseResponse;
        } else {
            try {
                Project modelProject = updateModel(project, id);
                projectService.updateProject(id, project);
                return new ProjectResponseObject(this.GET_UPDATE_SUCCESS + id, this.CODE_UPDATE_SUCCESS, modelProject);
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_UPDATE_FAIL, this.CODE_UPDATE_FAIL);
                return baseResponse;
            }
        }
    }


    public Project setModel(Project model) {
        Date date = new Date();
        model.setName(model.getName());
        model.setStartDate(model.getStartDate());
        model.setEndDate(model.getEndDate());
        model.setStatus(model.getStatus());
        model.setDescription(model.getDescription());
        model.setCustomersId(model.getCustomersId());
        model.setCreatedDate(date);
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }

    public Project updateModel(Project model, int id) {
        Date date = new Date();
        model.setId(id);
        model.setName(model.getName());
        model.setStartDate(model.getStartDate());
        model.setEndDate(model.getEndDate());
        model.setStatus(model.getStatus());
        model.setDescription(model.getDescription());
        model.setCustomersId(model.getCustomersId());
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }

}
