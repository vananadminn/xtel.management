package com.xmedia.springstart.controller.CategorySkill;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.response.CategorySkill.CategorySkillList;
import com.xmedia.springstart.response.CategorySkill.CategorySkillObject;
import com.xmedia.springstart.response.BaseResponse.CodeResponse;
import com.xmedia.springstart.model.CategorySkill.CategorySkill;
import com.xmedia.springstart.service.CategorySkill.CategorySkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("api/cat_skill")
public class CategorySkillController extends CodeResponse {

    @Autowired
    private BaseResponse baseResponse;

    @Autowired
    private CategorySkillService categorySkillService;

    @GetMapping("/getall")
    @ResponseBody
    public BaseResponse readAllCustomer() {
        List<CategorySkill> categorySkills = categorySkillService.getListSkill();
        int count = categorySkills.size();
        if (count == 0) {
            return new BaseResponse(this.GET_LIST_EMPTY + count, this.CODE_LIST_EMPTY);
        } else {
            return new CategorySkillList(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, categorySkills);
        }
    }

    @PostMapping(value = "add")
    @ResponseBody
    public BaseResponse addSkill(@RequestBody CategorySkill model) {
        if (categorySkillService.checkId(model.getId()) == null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
        } else {
            try {
                CategorySkill categorySkill = setModel(model);
                categorySkillService.addSkill(categorySkill);
                return new CategorySkillObject(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, categorySkill);
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_ADD_FAIL, this.CODE_ADD_FAIL);
            }
        }
        return baseResponse;
    }

    @PostMapping(value = "update/{id}")
    @ResponseBody
    public BaseResponse updateSkill(@PathVariable("id") int id, @RequestBody CategorySkill model) {
        if (categorySkillService.checkId(id) == null) {
            return new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
        } else {
            try {
                CategorySkill modelSkill = updateModel(model, id);
                categorySkillService.updateSkill(id, modelSkill);
                return new CategorySkillObject(this.GET_UPDATE_SUCCESS + id, this.CODE_UPDATE_SUCCESS, modelSkill);
            } catch (Exception e) {
                return new BaseResponse(this.GET_UPDATE_FAIL, this.CODE_UPDATE_FAIL);
            }
        }
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public BaseResponse deleteSkill(@PathVariable("id") int skillId) {
        if (categorySkillService.checkId(skillId) == null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
            return baseResponse;
        } else {
            try {
                categorySkillService.deleteSkill(skillId);
                baseResponse = new BaseResponse(this.GET_DELETE_SUCCESS, this.CODE_DELETE_FAIL);
                return baseResponse;
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_DELETE_FAIL, this.CODE_DELETE_FAIL);
                return baseResponse;
            }
        }
    }


    public CategorySkill setModel(CategorySkill model) {
        Date date = new Date();
        model.setId(randomId());
        model.setName(model.getName());
        model.setDescription(model.getDescription());
        model.setCreatedDate(date);
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }

    public CategorySkill updateModel(CategorySkill model, int id) {
        Date date = new Date();
        model.setId(id);
        model.setName(model.getName());
        model.setCreatedDate(date);
        model.setDescription(model.getDescription());
        return model;
    }

    public Integer randomId() {
        Random rand = new Random();
        int value = rand.nextInt(20000);
        System.out.println(value);
        return value;
    }

}
