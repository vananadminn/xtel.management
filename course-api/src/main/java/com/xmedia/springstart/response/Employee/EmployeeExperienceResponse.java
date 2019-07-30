package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.model.Employee;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmployeeExperienceResponse extends BaseResponse {

    private int id;
    private String name;
    private String email;
    private String skillName;
    private Date start;
    private Date now;

    public EmployeeExperienceResponse() {

    }

    public EmployeeExperienceResponse(String message, int code) {
        this.setMessage(message);
        this.setCode(code);
    }

    public EmployeeExperienceResponse(int id, String name, String email, String skillName, Date start, Date now) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skillName = skillName;
        this.start = start;
        this.now = now;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }
}
