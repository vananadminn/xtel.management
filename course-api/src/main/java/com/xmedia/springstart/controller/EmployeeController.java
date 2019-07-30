package com.xmedia.springstart.controller;

import com.ligerdev.appbase.utils.db.BaseDAO;
import com.xmedia.springstart.ResponseModel.SkillEmployee;
import com.xmedia.springstart.model.Skill;
import com.xmedia.springstart.request.*;
import com.xmedia.springstart.model.Employee;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.response.BaseResponse.CodeResponse;
import com.xmedia.springstart.response.Employee.*;
import com.xmedia.springstart.response.Skill.SkillEmployeeResponse;
import com.xmedia.springstart.service.Employee.EmployeeService;
import com.xmedia.springstart.ResponseModel.SeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/employee")
public class EmployeeController extends CodeResponse {

    @Autowired
    private BaseResponse baseResponse;

    @Autowired
    private EmployeeResponseObject employeeResponseObject;

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
            baseResponse = new BaseResponse(this.GET_CHECK_EMAIL, this.CODE_CHECK_EMAIL);
            return baseResponse;
        } else if (employeeService.checkPhone(employee.getPhone()) != null) {
            baseResponse = new BaseResponse(this.GET_CHECK_PHONE, this.CODE_CHECK_PHONE);
            return baseResponse;
        } else {
            try {
                Employee empModel = setModel(employee);
                employeeService.addEmp(empModel);
                return new EmployeeResponseObject(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, empModel);
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
            }
        }
        return baseResponse;
    }

    @PostMapping(value = "update/{id}")
    @ResponseBody
    public BaseResponse updateRole(@PathVariable("id") int id, @RequestBody Employee employee) {
        if (employeeService.checkId(employee.getId()) != null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_ID + id, this.CODE_DUPLICATE_ID);
            return baseResponse;
        } else if (employeeService.checkPhone(employee.getPhone()) == null) {
            baseResponse = new BaseResponse(this.GET_CHECK_PHONE, this.CODE_CHECK_PHONE);
            return baseResponse;
        } else if (employeeService.checkEmail(employee.getEmail()) == null) {
            baseResponse = new BaseResponse(this.GET_CHECK_EMAIL, this.CODE_CHECK_EMAIL);
            return baseResponse;
        } else {
            try {
                Employee empModel = updateModel(employee, id);
                employeeService.updateEmp(id, empModel);
                employeeResponseObject = new EmployeeResponseObject(this.GET_UPDATE_SUCCESS + id, this.CODE_UPDATE_SUCCESS, empModel);
                return employeeResponseObject;
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_UPDATE_FAIL, this.CODE_UPDATE_FAIL);
                return baseResponse;
            }
        }
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public BaseResponse deleteRole(@PathVariable("id") int roleId) {
        if (employeeService.checkId(roleId) == null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
            return baseResponse;
        } else {
            try {
                employeeService.deleteEmp(roleId);
                baseResponse = new BaseResponse(this.GET_DELETE_SUCCESS, this.CODE_DELETE_FAIL);
                return baseResponse;
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_DELETE_FAIL, this.CODE_DELETE_FAIL);
                return baseResponse;
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
    public BaseResponse findEmployeeByName(@RequestBody RequestEmployeeName requestEmployeeName) {
        List<Employee> findName = employeeService.findNameEmployee(requestEmployeeName.getName());
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
    public BaseResponse findEmployeeByPosition(@RequestBody RequestNamePosition requestNamePosition) {
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

    @PostMapping("search/skillemployee")
    @ResponseBody
    public BaseResponse findAmountEmployeeSkill(@RequestBody Employee model) {
        List<Employee> findAmount = employeeService.findAmountEmployeeSkill(model.getName());
        try {
            if (employeeService.checkEmployeeName(model.getName()) == null) {
                return new BaseResponse(this.GET_NAME_NOT_EXIST, this.CODE_GET_NAME_NOT_EXIST);
            } else {
                return new EmployeeSkillResponse(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, model.getName(), findAmount.size());
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
                SeResponse se = getSkillEmployeeByName(model.getName());
                return new SkillEmployeeResponse(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, se);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(this.GET_LIST_FAIL + e, this.CODE_GET_LIST_FAIL);
        }
    }

    @PostMapping("create/skill")
    @ResponseBody
    public BaseResponse createSkillEmployee(@RequestBody RequestCreateSkillEmployee model) {
        try {
            List<SkillEmployee> skillEmployeeList = employeeService.createSkillEmployee(model.getIdEmployee(), model.getIdSkill(), model.getCreatedBy());
            return new CreateSkillEmployeeResponse(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, skillEmployeeList);
        } catch (Exception e) {
            return new BaseResponse(this.GET_ADD_FAIL, this.CODE_ADD_FAIL);
        }
    }


    public Employee setModel(Employee modelEmp) {
        Date date = new Date();
        modelEmp.setName(modelEmp.getName());
        modelEmp.setPhone(modelEmp.getPhone());
        modelEmp.setEmail(modelEmp.getEmail());
        modelEmp.setStartDate(date);
        modelEmp.setStatus(true);
        modelEmp.setNote(modelEmp.getNote());
        modelEmp.setCreatedBy(modelEmp.getCreatedBy());
        modelEmp.setStatusProject(modelEmp.getStatusProject());
        return modelEmp;
    }

    public Employee updateModel(Employee model, int id) {
        Date date = new Date();
        model.setId(id);
        model.setName(model.getName());
        model.setPhone(model.getPhone());
        model.setEmail(model.getEmail());
        model.setEmployeeDate(model.getEmployeeDate());
        model.setEndDate(model.getEndDate());
        model.setStatus(model.getStatus());
        model.setNote(model.getNote());
        model.setStatusProject(model.getStatusProject());
        return model;
    }

    public SeResponse getSkillEmployeeByName(String name) throws SQLException {
        String sql = "select * from (select s.id, e.name as name , e.email as email, s.name as skillName, bx.start as start, bx.now as now FROM employee e join employee_experience ee on e.id = ee.employee_id join experience bx on bx.id = ee.experience_id join skill s on s.id = ee.skills_id where s.name ='" + name + "' )a";
        ResultSet rs = null;
        Connection con = null;
        ArrayList<SeResponse> list = new ArrayList<SeResponse>();
        SeResponse seResponse = new SeResponse();
        try {
            con = BaseDAO.getInstance("main").getConnection();
            rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                Date date = new Date();
                seResponse.setId(rs.getInt("id"));
                seResponse.setName(rs.getString("name"));
                seResponse.setEmail(rs.getString("email"));
                seResponse.setSkillName(rs.getString("skillName"));
                seResponse.setStart(rs.getDate("start"));
                seResponse.setNow(date);
                list.add(seResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
            rs.close();
        }
        return seResponse;
    }


}
