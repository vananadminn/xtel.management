package com.xmedia.springstart.controller;

import com.xmedia.springstart.model.Skill;
import com.xmedia.springstart.request.RequestSkillName;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.response.BaseResponse.CodeResponse;
import com.xmedia.springstart.response.Skill.SkillResponseList;
import com.xmedia.springstart.response.Skill.SkillResponseObject;
import com.xmedia.springstart.service.Skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/skill")
public class SkillController extends CodeResponse {

    @Autowired
    private SkillService skillService;


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

}
