package com.xmedia.springstart.model.Cv;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cv_interview")
public class CvInterview {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "cv_interview_id")
    private int cvInterviewId;

    @Column(name = "cv_interview_time")
    private Timestamp cvInterviewTime;

    @Column(name = "cv_quantity_user")
    private int cvQuantityUser;

    @Column(name = "cv_interview_result")
    private String cvInterviewResult;

    @Column(name = "cv_interview_point")
    private double cvInterviewPoint;

    @Column(name = "cv_interview_description")
    private String cvInterviewDescription;

    @Column(name = "cv_interview_status")
    private String cvInterviewStatus;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

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

    public int getCvInterviewId() {
        return cvInterviewId;
    }

    public void setCvInterviewId(int cvInterviewId) {
        this.cvInterviewId = cvInterviewId;
    }

    public Timestamp getCvInterviewTime() {
        return cvInterviewTime;
    }

    public void setCvInterviewTime(Timestamp cvInterviewTime) {
        this.cvInterviewTime = cvInterviewTime;
    }

    public int getCvQuantityUser() {
        return cvQuantityUser;
    }

    public void setCvQuantityUser(int cvQuantityUser) {
        this.cvQuantityUser = cvQuantityUser;
    }

    public String getCvInterviewResult() {
        return cvInterviewResult;
    }

    public void setCvInterviewResult(String cvInterviewResult) {
        this.cvInterviewResult = cvInterviewResult;
    }

    public double getCvInterviewPoint() {
        return cvInterviewPoint;
    }

    public void setCvInterviewPoint(double cvInterviewPoint) {
        this.cvInterviewPoint = cvInterviewPoint;
    }

    public String getCvInterviewDescription() {
        return cvInterviewDescription;
    }

    public void setCvInterviewDescription(String cvInterviewDescription) {
        this.cvInterviewDescription = cvInterviewDescription;
    }

    public String getCvInterviewStatus() {
        return cvInterviewStatus;
    }

    public void setCvInterviewStatus(String cvInterviewStatus) {
        this.cvInterviewStatus = cvInterviewStatus;
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
}
