package com.xmedia.springstart.controller.Employee;

import com.xmedia.springstart.model.Skill.Skill;
import com.xmedia.springstart.model.Employee.Employee;
import com.xmedia.springstart.request.DateTime.RequestDateTime;
import com.xmedia.springstart.request.Name.RequestEmployeeName;
import com.xmedia.springstart.request.Name.RequestPositionName;
import com.xmedia.springstart.request.Name.RequestSkillName;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.response.BaseResponse.CodeResponse;
import com.xmedia.springstart.response.Employee.*;
import com.xmedia.springstart.response.model.*;
import com.xmedia.springstart.response.Skill.SkillEmployeeResponse;
import com.xmedia.springstart.data_query_model.Employee.EmployeeSkill;
import com.xmedia.springstart.data_query_model.Employee.EmployeeSkillList;
import com.xmedia.springstart.data_query_model.SkillEmployeeListExperienceModel;
import com.xmedia.springstart.service.Employee.EmployeeService;
import com.xmedia.springstart.data_query_model.SeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.xmedia.springstart.data_query_model.Employee.EmployeeProcessList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/employee")
public class EmployeeController extends CodeResponse {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("read")
    @ResponseBody
    public BaseResponse getEmployeeList() {
        List<Employee> list = employeeService.getListEmp();
        int count = list.size();
        if (count == 0) {
            return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_GET_LIST_FAIL);
        } else {
            return new EmployeeResponseList(this.GET_LIST_SUCCESS + count, this.CODE_GET_LIST_SUCCESS, list);
        }
    }

    @PostMapping("/create")
    @ResponseBody
    public BaseResponse employeeResponseObject(@RequestBody Employee employee, Skill model) {
        if (employeeService.checkEmail(employee.getEmail()) != null) {
            return new BaseResponse(this.GET_CHECK_EMAIL, this.CODE_CHECK_EMAIL);
        } else if (employeeService.checkPhone(employee.getPhone()) != null) {
            return new BaseResponse(this.GET_CHECK_PHONE, this.CODE_CHECK_PHONE);
        } else {
            try {
                Employee empModel = ModelEmployee.set(employee);
                employeeService.addEmp(empModel);
                return new EmployeeResponseObject(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, empModel);
            } catch (Exception e) {
                return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
            }
        }
    }

    @PostMapping(value = "update/{id}")
    @ResponseBody
    public BaseResponse updateRole(@PathVariable("id") int id, @RequestBody Employee employee) {
        if (employeeService.checkId(employee.getId()) != null) {
            return new BaseResponse(this.GET_DUPLICATE_ID + id, this.CODE_DUPLICATE_ID);
        } else if (employeeService.checkPhone(employee.getPhone()) == null) {
            return new BaseResponse(this.GET_CHECK_PHONE, this.CODE_CHECK_PHONE);
        } else if (employeeService.checkEmail(employee.getEmail()) == null) {
            return new BaseResponse(this.GET_CHECK_EMAIL, this.CODE_CHECK_EMAIL);
        } else {
            try {
                Employee empModel = ModelEmployee.update(employee, id);
                employeeService.updateEmp(id, empModel);
                return new EmployeeResponseObject(this.GET_UPDATE_SUCCESS + id, this.CODE_UPDATE_SUCCESS, empModel);
            } catch (Exception e) {
                return new BaseResponse(this.GET_UPDATE_FAIL, this.CODE_UPDATE_FAIL);
            }
        }
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public BaseResponse deleteRole(@PathVariable("id") int roleId) {
        if (employeeService.checkId(roleId) == null) {
            return new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
        } else {
            try {
                employeeService.deleteEmp(roleId);
                return new BaseResponse(this.GET_DELETE_SUCCESS, this.CODE_DELETE_FAIL);
            } catch (Exception e) {
                return new BaseResponse(this.GET_DELETE_FAIL, this.CODE_DELETE_FAIL);
            }
        }
    }

    @GetMapping("working")
    @ResponseBody
    public BaseResponse listEmployeeWorking() {
        try {
            List<Employee> employeeList = employeeService.statusWorking();
            return new EmployeeResponseList(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, employeeList);
        } catch (Exception e) {
            return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
        }
    }

    @GetMapping("notworking")
    @ResponseBody
    public BaseResponse listEmployeeNotWorking() {
        List<Employee> employeeList = employeeService.statusNotWorking();
        int count = employeeList.size();
        if (count == 0) {
            return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
        } else {
            try {
                return new EmployeeResponseList(this.GET_LIST_SUCCESS + count, this.CODE_GET_LIST_SUCCESS, employeeList);
            } catch (Exception e) {
                return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
            }
        }
    }

    @PostMapping("time")
    @ResponseBody
    public BaseResponse listEmployeStartDateEndDate(@RequestBody RequestDateTime requestDateTime) throws Exception {
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(requestDateTime.getCreatedDate());
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(requestDateTime.getEmployeeDate());
        System.out.println(start.toString());
        try {
            List<Employee> employeeList = employeeService.listEmployeeTime(start, end);
            int count = employeeList.size();
            if (count == 0) {
                return new BaseResponse(this.GET_TIME_NOT_FOUND, this.CODE_TIME_NOTFOUND);
            } else {
                return new EmployeeResponseList(this.GET_LIST_SUCCESS + count, this.CODE_GET_LIST_SUCCESS, employeeList);
            }
        } catch (Exception e) {
            return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
        }
    }

    @PostMapping("search/name")
    @ResponseBody
    public BaseResponse findEmployeeByName(@RequestBody RequestEmployeeName model) {
        List<Employee> findName = employeeService.findNameEmployee(model.getName());
        int count = findName.size();
        if (count == 0) {
            return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
        } else {
            try {
                return new EmployeeResponseList(this.GET_LIST_SUCCESS + count, this.CODE_GET_LIST_SUCCESS, findName);
            } catch (Exception e) {
                return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
            }
        }
    }

    @PostMapping("search/position")
    @ResponseBody
    public BaseResponse findEmployeeByPosition(@RequestBody RequestPositionName requestNamePosition) {
        List<Employee> findPosition = employeeService.findPositionEmployee(requestNamePosition.getName());
        try {
            if (findPosition.size() == 0) {
                return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
            } else {
                return new EmployeeResponseList(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, findPosition);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
        }
    }

    @PostMapping("search/experience")
    @ResponseBody
    public BaseResponse experienceEmployee(@RequestBody RequestSkillName model) {
        String findSkillName = employeeService.findSkillName(model.getName());
        try {
            if (findSkillName == null) {
                return new BaseResponse(this.GET_NAME_NOT_EXIST, this.CODE_GET_NAME_NOT_EXIST);
            } else {
                SeResponse se = GetSkillEmployeeByName.GSEBN(model.getName());
                return new SkillEmployeeResponse(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, se);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(this.GET_LIST_FAIL + e, this.CODE_GET_LIST_FAIL);
        }
    }

    @GetMapping("get/experience")
    @ResponseBody
    public BaseResponse skillEmployeeListExperience() {
        try {
            List<SkillEmployeeListExperienceModel> listResponse = GetListEmployeeExperience.GLEE();
            int count = listResponse.size();
            if (count == 0) {
                return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
            } else {
                return new EmployeeExperienceList(this.GET_LIST_SUCCESS + count, this.CODE_GET_LIST_SUCCESS, listResponse);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
        }
    }

    @GetMapping("get/employee_skill")
    @ResponseBody
    public BaseResponse getListEmployeeSkill() {
        try {
            List<EmployeeSkillList> list = GetListEmployeeSkill.GLES();
            int count = list.size();
            if (count == 0) {
                return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
            } else {
                return new EmployeesSkillsResponse(this.GET_LIST_SUCCESS + count, this.CODE_GET_LIST_SUCCESS, list);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
        }
    }

    @PostMapping("search/skillName")
    @ResponseBody
    public BaseResponse getEmployeeSkillByEmployeeName(@RequestBody RequestEmployeeName model) {
        try {
            List<EmployeeSkill> list = EmployeeSkills.ES(model.getName());
            int count = list.size();
            if (count == 0) {
                return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
            } else {
                return new EmployeeSkillResponse(this.GET_LIST_SUCCESS + count, this.CODE_GET_LIST_SUCCESS, list);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
        }
    }

    @GetMapping("get/process")
    @ResponseBody
    public BaseResponse getListEmployeeProcess() {
        try {
            List<EmployeeProcessList> list = GetListEmployeeProcess.getListEmployeeProcess();
            int count = list.size();
            if (count == 0) {
                return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
            } else {
                return new EmployeeProcessListResponse(this.GET_LIST_SUCCESS + count, this.CODE_GET_LIST_SUCCESS, list);
            }
        } catch (Exception e) {
            System.out.println("Sai hộ bố m cái");
            return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
        }
    }


    @PostMapping("get/processByName/")
    @ResponseBody
    public BaseResponse getListEmployeeProcessByName(@RequestBody RequestEmployeeName model) {
        try {
            List<EmployeeProcessList> list;
            if (GetListEmployeeProcessByName.GLEP(model.getName()).isEmpty()) {
                return new BaseResponse(this.GET_EMPLOYEE_NAME_NOTFOUND, this.CODE_GET_EMPLOYEE_NAME_NOTFOUND);
            } else {
                list = GetListEmployeeProcessByName.GLEP(model.getName());
                return new EmployeeProcessListResponse(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, list);
            }
        } catch (Exception e) {
            return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
        }
    }

//    @PostMapping
//    public BaseResponse getListById(@RequestBody RequestEmployeeName model) {
//        try {
//            List<EmployeeProcessList> list;
//            if (GetListEmployeeProcessByName.GLEP(model.getName()) == null) {
//
//            } else {
//
//            }
//
//        } catch (Exception e) {
//
//        }
//    }
}
