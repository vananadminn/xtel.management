package com.xmedia.springstart.repository;

import com.xmedia.springstart.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT p.name FROM Project p WHERE p.name = ?1")
    String findName(String projectName);

    @Query("SELECT p.id FROM Project p WHERE p.id=?1")
    String checkId(int id);

}
