package com.xmedia.springstart.request;

public class RequestEmployeeName {

    private String name;

    public RequestEmployeeName() {

    }

    public RequestEmployeeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
