package com.xmedia.springstart.response.Employee;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;

import java.util.List;

public class EmployeeProcessListByName extends BaseResponse {


    private List<EmployeeProcessListByName> listByNames;

    public EmployeeProcessListByName(List<EmployeeProcessListByName> listByNames) {
        this.listByNames = listByNames;
    }

    public EmployeeProcessListByName(String message, int code, List<EmployeeProcessListByName> listByNames) {
        super(message, code);
        this.listByNames = listByNames;
    }

    public List<EmployeeProcessListByName> getListByNames() {
        return listByNames;
    }

    public void setListByNames(List<EmployeeProcessListByName> listByNames) {
        this.listByNames = listByNames;
    }
}
