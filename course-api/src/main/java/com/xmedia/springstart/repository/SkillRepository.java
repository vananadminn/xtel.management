package com.xmedia.springstart.repository;

import com.xmedia.springstart.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
    /*return name if param value is exists*/
    @Query(value = "select s.name FROM Skill s where s.name = :name", nativeQuery = true)
    String findSkillName(@Param("name") String name);

    /*return id key if param value is exists*/
    @Query(value = "select s.id FROM Skill s where s.id = :id", nativeQuery = true)
    String findSkillId(@Param("id") int id);

    /*return skill information if exists param value is skill name*/
    @Query(value = "select s.* from Skill s where s.name = :name", nativeQuery = true)
    List<Skill> listSkill(@Param("name") String name);
}
