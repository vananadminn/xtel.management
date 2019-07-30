package com.xmedia.springstart.response.CategorySkill;

import com.xmedia.springstart.model.CategorySkill;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;

import java.util.List;

public class CategorySkillList extends BaseResponse {
    List<CategorySkill> categorySkillList;

    public CategorySkillList() {

    }

    public CategorySkillList(String message, int code, List<CategorySkill> categorySkills) {
        this.setMessage(message);
        this.setCode(code);
        this.categorySkillList = categorySkills;
    }

    public List<CategorySkill> getCategorySkillList() {
        return categorySkillList;
    }

    public void setCategorySkillList(List<CategorySkill> categorySkillList) {
        this.categorySkillList = categorySkillList;
    }
}
