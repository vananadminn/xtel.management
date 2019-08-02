package com.xmedia.springstart.repository;

import com.xmedia.springstart.model.CategorySkill.CategorySkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategorySkillRepository extends JpaRepository<CategorySkill, Integer> {

    @Query("SELECT c.id FROM CategorySkill c WHERE c.id=?1")
    Integer checkId(int id);
}
