package com.xmedia.springstart.request;

public class RequestDateTime {
    private String createdDate;
    private String employeeDate;

    public RequestDateTime() {

    }

    public RequestDateTime(String createdDate, String employeeDate) {
        this.createdDate = createdDate;
        this.employeeDate = employeeDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEmployeeDate() {
        return employeeDate;
    }

    public void setEmployeeDate(String employeeDate) {
        this.employeeDate = employeeDate;
    }
}
