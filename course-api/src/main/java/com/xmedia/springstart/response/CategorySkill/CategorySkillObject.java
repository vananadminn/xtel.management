package com.xmedia.springstart.response.CategorySkill;

import com.xmedia.springstart.model.CategorySkill.CategorySkill;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;

public class CategorySkillObject extends BaseResponse {

    private CategorySkill categorySkills;

    public CategorySkillObject() {

    }

    public CategorySkillObject(String message, int code, CategorySkill categorySkills) {
        this.setMessage(message);
        this.setCode(code);
        this.categorySkills = categorySkills;
    }

    public CategorySkill getCategorySkillList() {
        return categorySkills;
    }

    public void setCategorySkillList(CategorySkill categorySkillList) {
        this.categorySkills = categorySkillList;
    }
}
