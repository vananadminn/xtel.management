package com.xmedia.springstart.controller.Skill;

import com.ligerdev.appbase.utils.db.BaseDAO;
import com.xmedia.springstart.model.Skill.Skill;
import com.xmedia.springstart.model.Skill.SkillsEmployees;
import com.xmedia.springstart.request.Name.RequestSkillName;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.response.BaseResponse.CodeResponse;
import com.xmedia.springstart.response.Employee.CreateSkillEmployeeResponse;
import com.xmedia.springstart.response.Skill.SkillResponseList;
import com.xmedia.springstart.response.Skill.SkillResponseObject;
import com.xmedia.springstart.data_query_model.Employee.SEResponse;
import com.xmedia.springstart.service.Skill.SkillService;
import com.xmedia.springstart.service.SkillEmployee.SkillEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/skill")
public class SkillController extends CodeResponse {

    @Autowired
    private SkillService skillService;

    @Autowired
    private SkillEmployeeService skillEmployeeService;


    @GetMapping("read")
    @ResponseBody
    public BaseResponse getSkillList() {
        List<Skill> list = skillService.getListSkill();
        int count = list.size();
        if (count == 0) {
            return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_GET_LIST_FAIL);
        } else {
            return new SkillResponseList(this.GET_LIST_SUCCESS + count, this.CODE_GET_LIST_SUCCESS, list);
        }
    }

    @PostMapping("/create")
    @ResponseBody
    public BaseResponse createSkill(@RequestBody Skill skill) {
        if (skillService.findSkillName(skill.getName()) != null) {
            return new BaseResponse(this.GET_DUPLICATE_NAME + skill.getName(), this.CODE_DUPLICATE_NAME);
        } else {
            try {
                Skill skModel = setModel(skill);
                skillService.addSkill(skModel);
                return new SkillResponseObject(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, skModel);
            } catch (Exception e) {
                return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
            }
        }
    }

    @PostMapping(value = "update/{id}")
    @ResponseBody
    public BaseResponse updateSkill(@PathVariable("id") int id, @RequestBody Skill skill) {
        if (skillService.findSkillId(skill.getId()) == null) {
            return new BaseResponse(this.GET_DUPLICATE_ID + id, this.CODE_DUPLICATE_ID);
        } else {
            try {
                Skill skiModel = updateModel(skill, id);
                skillService.updateSkill(id, skiModel);
                return new SkillResponseObject(this.GET_UPDATE_SUCCESS + id, this.CODE_UPDATE_SUCCESS, skiModel);
            } catch (Exception e) {
                return new BaseResponse(this.GET_UPDATE_FAIL, this.CODE_UPDATE_FAIL);
            }
        }
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public BaseResponse deleteSkill(@PathVariable("id") int skillId) {
        if (skillService.findSkillId(skillId) == null) {
            return new BaseResponse(this.GET_DUPLICATE_ID + skillId, this.CODE_DUPLICATE_ID);
        } else {
            try {
                skillService.deleteSkill(skillId);
                return new BaseResponse(this.GET_DELETE_SUCCESS + skillId, this.CODE_DELETE_FAIL);
            } catch (Exception e) {
                return new BaseResponse(this.GET_DELETE_FAIL + skillId, this.CODE_DELETE_FAIL);
            }
        }
    }

    @PostMapping("/search/skill")
    @ResponseBody
    public BaseResponse searchSkillName(@RequestBody RequestSkillName model) {
        if (skillService.findSkillName(model.getName()) == null) {
            return new BaseResponse(this.GET_NAME_NOT_EXIST, this.CODE_GET_NAME_NOT_EXIST);

        } else {
            try {
                List<Skill> listSkill = skillService.searchSkillByName(model.getName());
                if (listSkill != null) {
                    return new SkillResponseList(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, listSkill);
                } else {
                    return new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
                }
            } catch (Exception e) {
                return new BaseResponse(this.GET_LIST_FAIL, this.CODE_GET_LIST_FAIL);
            }
        }
    }

    @PostMapping("create/employee")
    @ResponseBody
    public BaseResponse createSkillEmployee(@RequestBody SkillsEmployees model) {
        try {
            if (checkIdEmployeeAndIdSkill(model)) {
                return new BaseResponse(GET_EMPLOYEE_EXISTS_SKILL + model.getSkillsId(), CODE_EMPLOYEE_EXISTS_SKILL);
            } else if (skillEmployeeService.findIdEmployee(model.getEmployeesId()) == null) {
                return new BaseResponse(this.GET_EMPLOYEE_NEXISTS_ID, this.CODE_EMPLOYEE_NEXISTS_ID);
            } else {
                SkillsEmployees se = setModelCreateSkillEmployee(model);
                skillEmployeeService.addSkillEmployee(se);
                return new CreateSkillEmployeeResponse(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, se);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(this.GET_ADD_FAIL, this.CODE_ADD_FAIL);
        }
    }

    @PostMapping("edit/employee")
    @ResponseBody
    public BaseResponse updateSkillEmployee(@RequestBody SkillsEmployees model) {
        try {
            if (skillEmployeeService.findIdSkillEmployee(model.getId()) == null) {
                return new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
            } else if (skillEmployeeService.findIdEmployee(model.getEmployeesId()) == null) {
                return new BaseResponse(this.GET_EMPLOYEE_NEXISTS_ID, this.CODE_EMPLOYEE_NEXISTS_ID);
            } else if (skillEmployeeService.findIdSkill(model.getSkillsId()) == null) {
                return new BaseResponse(this.GET_SKILL_ID_NOTFOUND, this.CODE_SKILL_ID_NOTFOUND);
            } else {
                SkillsEmployees se = updateModelSkillEmployee(model, model.getId(), model.getEmployeesId());
                return new CreateSkillEmployeeResponse(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, se);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(this.GET_UPDATE_FAIL, this.CODE_UPDATE_FAIL);
        }
    }

    @PostMapping("delete/employee")
    @ResponseBody
    public BaseResponse updateSkillEmployee(@RequestBody SEResponse model) {
        try {
            if (skillEmployeeService.findIdEmployee(model.getEmployeesId()) == null) {
                return new BaseResponse(this.GET_EMPLOYEE_NEXISTS_ID, this.CODE_EMPLOYEE_NEXISTS_ID);
            } else if (skillEmployeeService.findIdSkillEmployee(model.getId()) == null) {
                return new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
            } else {
                skillEmployeeService.deleteSkillEmployeeByIdEmployeeAndIdPrimary(model.getEmployeesId(), model.getId());
                return new BaseResponse(this.GET_DELETE_SUCCESS, this.CODE_DELETE_SUCCESS);
            }
        } catch (Exception e) {
            System.out.println(e);
            return new BaseResponse(this.GET_DELETE_FAIL, this.CODE_DELETE_FAIL);
        }
    }


    public SkillsEmployees setModelCreateSkillEmployee(SkillsEmployees model) {
        Date date = new Date();
        model.setEmployeesId(model.getEmployeesId());
        model.setSkillsId(model.getSkillsId());
        model.setCreatedDate(date);
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }

    public SkillsEmployees updateModelSkillEmployee(SkillsEmployees model, int id, int idEmployee) {
        Date date = new Date();
        model.setId(id);
        model.setEmployeesId(idEmployee);
        model.setSkillsId(model.getSkillsId());
        model.setCreatedDate(date);
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }

    public Skill setModel(Skill model) {
        Date date = new Date();
        model.setName(model.getName());
        model.setDescription(model.getDescription());
        model.setCategoryId(model.getCategoryId());
        model.setCreatedDate(date);
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }

    public Skill updateModel(Skill model, int id) {
        Date date = new Date();
        model.setId(id);
        model.setName(model.getName());
        model.setDescription(model.getDescription());
        model.setCategoryId(model.getCategoryId());
        model.setCreatedDate(date);
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }

    public Boolean checkIdEmployeeAndIdSkill(SkillsEmployees model) throws SQLException {
        String sql = "select employees_id, skills_id from skills_employees where employees_id =" + "'" + model.getEmployeesId() + "'" + " and skills_id =" + "'" + model.getSkillsId() + "'";
        ResultSet rs = null;
        Connection con = null;
        ArrayList<SkillsEmployees> list = new ArrayList<SkillsEmployees>();
        try {
            con = BaseDAO.getInstance("main").getConnection();
            rs = con.prepareStatement(sql).executeQuery();
            if (rs.next() && rs.getInt(1) != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
            rs.close();
        }
        return false;
    }

}
