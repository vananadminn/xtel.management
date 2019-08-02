package com.xmedia.springstart.model.Skill;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "skills_employees", schema = "xtel.management", catalog = "")
public class SkillsEmployees {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "employees_id")
    private int employeesId;

    @Column(name = "skills_id")
    private int skillsId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "skill_start")
    private Date skillStart;

    @Column(name = "skill_end")
    private Date skillEnd;

    public SkillsEmployees() {

    }

    public SkillsEmployees(int id, int employeesId, Date createdDate, String createdBy, Date skillStart, Date skillEnd) {
        this.id = id;
        this.employeesId = employeesId;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.skillStart = skillStart;
        this.skillEnd = skillEnd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(int employeesId) {
        this.employeesId = employeesId;
    }

    public int getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(int skillsId) {
        this.skillsId = skillsId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getSkillStart() {
        return skillStart;
    }

    public void setSkillStart(Date skillStart) {
        this.skillStart = skillStart;
    }

    public Date getSkillEnd() {
        return skillEnd;
    }

    public void setSkillEnd(Date skillEnd) {
        this.skillEnd = skillEnd;
    }
}
