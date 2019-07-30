package com.xmedia.springstart.request;

public class RequestCreateSkillEmployee {

    private int idEmployee;
    private int idSkill;
    private String createdBy;

    public RequestCreateSkillEmployee() {

    }

    public RequestCreateSkillEmployee(int idEmployee, int idSkill, String createdBy) {
        this.idEmployee = idEmployee;
        this.idSkill = idSkill;
        this.createdBy = createdBy;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
